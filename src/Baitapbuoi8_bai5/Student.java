package Baitapbuoi8_bai5;

public class Student {
    String name;
    String id;
    double mathMark;
    double physicsMark;
    double chemistryMark;
    double averageScore;
    String rank;
    public Student(String name, String id, double mathMark, double physicsMark, double chemistryMark) {
        this.name = name;
        this.id = id;
        this.mathMark = mathMark;
        this.physicsMark = physicsMark;
        this.chemistryMark = chemistryMark;
    }
    public void calcScoreAverage() {
        this.averageScore = (this.mathMark + this.physicsMark + this.chemistryMark)/3;
    }
    public void ranking() {
        if(this.averageScore >= 9) {
            this.rank = "Excellence";
        } else if (this.averageScore >=8) {
            this.rank = "Good";
        } else if (this.averageScore >= 7) {
            this.rank = "Fair";
        } else if (this.averageScore >=6 ) {
            this.rank = "Fair-Average";
        } else if (this.averageScore >=5 ) {
            this.rank = "Average";
        } else {
            this.rank = "Weak";
        }
    }
}
