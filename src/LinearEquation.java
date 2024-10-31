public class LinearEquation {
    private int x1, x2, y1, y2;
    private double slope;
    private double yIntercept;


    public LinearEquation(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.slope = slope;
        this.yIntercept = yIntercept;
    }


    public double distance() {
        return roundHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double slope() {
        slope = roundHundredth(((double) (y2 - y1) /(x2- x1)));
        return slope;
    }


    public double yIntercept() {
        yIntercept = roundHundredth((y1 - slope() * x1));
        return yIntercept;
    }

    private double roundHundredth(double num){
        return Math.round(num * 100.0) / 100.0;
    }

    public String equation() {
        if ((y2 - y1) == 0) {
            return "y = " + yIntercept;
        } else {
            return "y = " + (y2 - y1) + "/" + (x2 - x1)  + " + " + yIntercept;
        }
    }

    public String coordinateForX(double x) {
        double yValue = ((slope * x) + yIntercept);
        return "(" + x + ", " + yValue + ")";
    }

    public String lineInfo() {
        String firstStatement = "The two points are: " + "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")";
        String secondStatement = "The equation of the line between these points is: " + equation();
        String thirdStatement = "The y-intercept of this line is: " + yIntercept;
        String fourthStatement = "The slope of this line is: " + slope;
        String fifthStatement = "The distance between these points is: " + distance();
        return firstStatement + "\n" + secondStatement + "\n" + thirdStatement + "\n" + fourthStatement + "\n" + fifthStatement;
    }
}