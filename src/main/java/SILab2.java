import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public List<Integer> function(List<Time> timesList) {//1
        List<Integer> result = new ArrayList<>();//2

        for (int i = 0; i < timesList.size(); i++) {//3
            int hr = timesList.get(i).getHours();//4
            int min = timesList.get(i).getMinutes();//5
            int sec = timesList.get(i).getSeconds();//6
            if (hr < 0 || hr > 24){//7
                if (hr < 0){//8
                    throw new RuntimeException("The hours are smaller than the minimum");//9
                }
                else {//10
                    throw new RuntimeException("The hours are grater than the maximum");//11
                }
            }
            else if (hr < 24) {//12
                if (min < 0 || min > 59)//13
                    throw new RuntimeException("The minutes are not valid!");//14
                else {//15
                    if (sec >= 0 && sec <= 59)//16
                        result.add(hr * 3600 + min * 60 + sec);//17
                    else//18
                        throw new RuntimeException("The seconds are not valid");//19
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) {//20
                    result.add(hr * 3600 + min * 60 + sec);//21
            } 
            else {//22
                throw new RuntimeException("The time is greater than the maximum");//23
            }
        }//24
        return result;//25
    }//26
}