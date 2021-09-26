package HW1Pr1.Master;

import HW1Pr1.Pack.Pool;
import HW1Pr1.Pack.Track;
import HW1Pr1.Skills.CanRun;
import HW1Pr1.Skills.CanSwim;

public class Man implements  CanSwim, CanRun {
    private double result;
    private String name;
    private double speed;
    private double swimSkills;
    public Man (String name, double speed, double swimSkills){
        if (swimSkills <= 0 ) swimSkills = 1;
        this.setName(name);
        this.setSpeed(speed);
        this.setSwimSkills(swimSkills);
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getSwimSkills() {
        return swimSkills;
    }

    public void setSwimSkills(double swimSkills) {
        this.swimSkills = swimSkills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public double swim(Pool p) {
        System.out.println(this.getName() + " Плывёт");
        result += p.getLength() / (this.getSpeed() * this.getSwimSkills());
        return result;
    }
    @Override
    public double run (Track t){
        System.out.println(this.getName() + " Бежит");
        result += t.getLength() / this.getSpeed();
        return result;
    }
}

