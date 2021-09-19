package HW1Pr1.Master;

import HW1Pr1.Pack.Course;
import HW1Pr1.Pack.CourseEntity;
import HW1Pr1.Pack.Pool;
import HW1Pr1.Pack.Track;

public class Team {
    private String teamName;
    Man [] teamArr;
    public Team (String teamName, Man [] teamArr){
        this.setTeamName(teamName);
        this.setTeamArr(teamArr);
    }

    public Man[] getTeamArr() {
        return teamArr;
    }

    public void setTeamArr(Man[] teamArr) {
        this.teamArr = teamArr;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void getInfo (){
        for (Man t : teamArr) {
            System.out.println(t.getName() + ", скорость = " + t.getSpeed() + " Результат: " + t.getResult());
        }
    }
    public void play (Course course){
        System.out.println("START");
        for (Man h : teamArr) {
            System.out.println(teamArr.length);
            for (CourseEntity c : course.getCourseArr()){
                String flag = c.getClassName();
                if ( flag == "Бассейн"){
                    h.swim((Pool)c);
                }else if (flag == "Площадка"){
                    h.run((Track)c);
                }
            }
        }
    }
}