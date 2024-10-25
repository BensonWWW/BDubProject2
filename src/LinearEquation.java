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
}