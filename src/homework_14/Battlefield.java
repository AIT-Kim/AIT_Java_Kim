package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Battlefield {

    public static final int SIZE = 10; // Размер игрового поля,  10x10
    private CellStatus[][] grid;
    private Ship[][] shipGrid; // Дополнительная сетка для хранения ссылок на корабли

    public Battlefield() {
        grid = new CellStatus[SIZE][SIZE];
        shipGrid = new Ship[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = CellStatus.UNKNOWN;
            }
        }
    }

    // Получение статуса ячейки по координатам
    public CellStatus getCellStatus(Coordinates coords) {
        return grid[coords.getX()][coords.getY()];
    }


    public boolean placeShip(Ship ship, Coordinates start) {
        if (canPlaceShip(ship, start)) {
            int x = start.getY();
            int y = start.getX();

            for (int i = 0; i < ship.getLength(); i++) {
                grid[x][y] = CellStatus.SHIP;
                shipGrid[x][y] = ship;
                if (ship.isVertical()) {
                    x++;
                } else {
                    y++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean canPlaceShip(Ship ship, Coordinates start) {
        int x = start.getY();
        int y = start.getX();

        for (int i = 0; i < ship.getLength(); i++) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }

            if (grid[x][y] == CellStatus.SHIP || !isAdjacentClear(x, y)) {
                return false;
            }

            if (ship.isVertical()) {
                x++;
            } else {
                y++;
            }
        }
        return true;
    }

    private boolean isAdjacentClear(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int checkX = x + i;
                int checkY = y + j;

                if (checkX < 0 || checkX >= grid.length || checkY < 0 || checkY >= grid[0].length) {
                    continue;
                }

                if (grid[checkX][checkY] == CellStatus.SHIP) {
                    return false;
                }
            }
        }
        return true;
    }





    private boolean isValidPlacementCell(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && grid[x][y] != CellStatus.SHIP;
    }





    public CellStatus shootAt(Coordinates coords) {
        int x = coords.getY();
        int y = coords.getX();

        if (grid[x][y] == CellStatus.HIT) {
            return CellStatus.ALREADY_HIT;
        }

        if (grid[x][y] == CellStatus.SHIP) {
            // Получаем корабль из сетки кораблей
            Ship ship = shipGrid[x][y];

            // Получаем индекс корабля
            int shipIndex = getShipIndex(ship, coords);
            if (shipIndex == -1) {
                System.err.println("Error: Invalid ship index for coordinates (" + x + "," + y + ").");
                return CellStatus.MISS;
            }

            // Обновляем статус корабля
            CellStatus shipStatus = ship.shootAt(shipIndex);

            // Обновляем сетку
            grid[x][y] = CellStatus.HIT;

            // Если корабль уничтожен
            if (ship.isDestroyed()) {
                return CellStatus.DESTROYED;
            }

            return shipStatus;
        } else {
            grid[x][y] = CellStatus.MISS;
            return CellStatus.MISS;
        }
    }



    private int getShipIndex(Ship ship, Coordinates coords) {
        int startX = ship.getStartY();
        int startY = ship.getStartX();
        int endX = ship.isVertical() ? startX + ship.getLength() - 1 : startX;
        int endY = !ship.isVertical() ? startY + ship.getLength() - 1 : startY;

        int currentX = startX;
        int currentY = startY;

        for (int i = 0; i < ship.getLength(); i++) {
            if (currentX == coords.getY() && currentY == coords.getX()) {
                return i;
            }

            if (ship.isVertical()) {
                currentX++;
            } else {
                currentY++;
            }
        }
        return -1;
    }


    public void display(Player player) {
        display(player, false);
    }

    public void display(Player player, boolean useRedColor) {
        if (useRedColor) {
            System.out.print("\033[31m"); // Устанавливаем красный цвет
        }
        System.out.println("Поле игрока:  " + player.name);
        System.out.print("  "); // для выравнивания

        // Выводим числовые обозначения для оси X
        for (int j = 0; j < SIZE; j++) {
            System.out.printf("%2d", j + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            // Выводим буквенные обозначения для оси Y
            System.out.print((char) ('A' + i) + "  ");

            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j].getRepresentation() + " ");
            }
            System.out.println();
        }

        if (useRedColor) {
            System.out.print("\033[0m"); // Сбрасываем цвет
        }
    }





    public void displayHidden(Player player) {
        System.out.println("Поле игрока:  " + player.name);
        System.out.print("  ");

        // Выводим числовые обозначения для оси X
        for (int j = 0; j < SIZE; j++) {
            System.out.printf("%2d", j + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            // Выводим буквенные обозначения для оси Y
            System.out.print((char) ('A' + i) + "  ");

            for (int j = 0; j < SIZE; j++) {
                // Если на клетке корабль - отображаем как UNKNOWN, иначе показываем состояние клетки
                if (grid[i][j] == CellStatus.SHIP) {
                    System.out.print(CellStatus.UNKNOWN.getRepresentation() + " ");
                } else {
                    System.out.print(grid[i][j].getRepresentation() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean allShipsDestroyed() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == CellStatus.SHIP) {
                    return false;
                }
            }
        }
        return true;
    }
}
