public class LinearEquation {
    private int x1, y1, x2, y2;
    private double slope;
    private double yIntercept;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        if (x1 != x2) {
            this.slope = roundedToHundredth(calculateSlope());
            this.yIntercept = roundedToHundredth(calculateYIntercept());
        }
    }

    private double calculateSlope() {
        return (double) (y2 - y1) / (x2 - x1);
    }

    private double calculateYIntercept() {
        return y1 - (slope * x1);
    }

    public double distance() {
        double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return roundedToHundredth(dist);
    }

    public double yIntercept() {
        return yIntercept;
    }

    public double slope() {
        return slope;
    }

    public String equation() {
        if (x1 == x2) {
            return "x = " + x1;
        }

        int rise = y2 - y1;
        int run = x2 - x1;
        String slopeStr;

        if (rise == 0) {
            return "y = " + yIntercept;
        } else if (run == 1 || run == -1) {
            slopeStr = (rise == run) ? "" : (rise < 0 ? "-" : "") + Math.abs(rise) + "/1";
        } else if (Math.abs(rise) % Math.abs(run) == 0) {
            slopeStr = String.valueOf(rise / run);
        } else {
            slopeStr = rise + "/" + run;
            if (run < 0) {
                slopeStr = "-" + Math.abs(rise) + "/" + Math.abs(run);
            }
        }

        String yInterceptStr = (yIntercept == 0) ? "" : (yIntercept < 0 ? " - " : " + ") + Math.abs(yIntercept);
        return "y = " + slopeStr + "x" + yInterceptStr;
    }

    public String coordinateForX(double x) {
        if (x1 == x2) {
            return "No valid y value for this x on a vertical line";
        }
        double y = slope * x + yIntercept;
        return "(" + roundedToHundredth(x) + ", " + roundedToHundredth(y) + ")";
    }

    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The y intercept of this line is: " + yIntercept + "\n" +
                "The slope of this line is: " + slope + "\n" +
                "The distance between these points is " + distance();
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }
}