package t1;

public class Apple {

    Apple(String color,Integer Weight){
        this.color=color;
        this.Weight=Weight;

    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    private Integer Weight;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private  String color;
}
