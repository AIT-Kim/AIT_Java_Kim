package lesson_20;


class Cat20 {

    private String catName;
    private int years;
    private int mass;

    public Cat20(String name, int age, int weight) {
        this.catName = name;
        if (isValidAge(age)) {
            this.years = age;
        }
        if (isValidWeight(weight)) {
            this.mass = weight;
        }
    }

    private boolean isValidAge(int ageCheck) {
        return ageCheck > 0 && ageCheck < 20;
    }

    private boolean isValidWeight(int weightCheck) {
        return weightCheck > 0 && weightCheck < 50;
    }

    public String obtainName() {
        return this.catName;
    }

    public void modifyAge(int newYears) {
        if (isValidAge(newYears)) {
            this.years = newYears;
        }
    }

    public int obtainAge() {
        return this.years;
    }

    public void modifyWeight(int newMass) {
        if (isValidWeight(newMass)) {
            this.mass = newMass;
        }
    }

    public int obtainWeight() {
        return this.mass;
    }
}
