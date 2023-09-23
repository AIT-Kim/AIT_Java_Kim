package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Ship {

    private CellStatus[] cells;
    private boolean isVertical;

    private int startX;
    private int startY;


    public Ship(int length, Coordinates start, boolean isVertical) {
        this.cells = new CellStatus[length];
        this.isVertical = isVertical;
        this.startX = start.getX();
        this.startY = start.getY();

        for (int i = 0; i < length; i++) {
            cells[i] = CellStatus.SHIP;
        }
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }


    // Check the status of the ship
    public ShipStatus getStatus() {
        int hitCount = 0;

        for (CellStatus cell : cells) {
            if (cell == CellStatus.HIT) {
                hitCount++;
            }
        }

        if (hitCount == 0) {
            return ShipStatus.INTACT;
        } else if (hitCount == cells.length) {
            return ShipStatus.DESTROYED;
        } else {
            return ShipStatus.DAMAGED;
        }
    }

    public CellStatus shootAt(int index) {
        // Проверяем, что индекс находится в допустимом диапазоне
        if (index >= 0 && index < cells.length) {
            if (cells[index] == CellStatus.SHIP) {
                if (isShipAlreadyHit()) {
                    // Попадание в корабль, в который уже попадали, но не в эту ячейку
                    cells[index] = CellStatus.HIT; // Обновляем статус ячейки
                    return CellStatus.SHIP_ALREADY_HIT;
                } else {
                    cells[index] = CellStatus.HIT; // Обновляем статус ячейки
                    return CellStatus.HIT; // Новое попадание в корабль
                }
            } else if (cells[index] == CellStatus.HIT) {
                // Попадание в ячейку, в которую уже стреляли
                return CellStatus.ALREADY_HIT;
            }
            return CellStatus.MISS;
        } else {
            throw new IllegalArgumentException("Invalid index provided: " + index);
        }
    }



    private boolean isShipAlreadyHit() {
        for (CellStatus cell : cells) {
            if (cell == CellStatus.HIT) {
                return true;
            }
        }
        return false;
    }


    public int getLength() {
        return cells.length;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public boolean isDestroyed() {
        return getStatus() == ShipStatus.DESTROYED;
    }

}



