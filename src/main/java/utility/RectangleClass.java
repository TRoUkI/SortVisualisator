package main.java.utility;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleClass extends Rectangle {

    public RectangleClass(double v, double v1) {
        super(v,v1);
        this.setFill(Color.web("#2C3639"));
        this.setStroke(Color.web("#3F4E4F"));
        this.setStyle("-fx-stroke-type:inside; -fx-stroke-width: 1;");
    }

    //function correct the Y axis in Pane box
    public void correctRectanglePlacement(Pane box){
        this.setY(box.getMaxHeight()-this.getHeight());
    }
    //function for changing X position of rectangle
    public void changeRectangleXPosition(int pos) {
        this.setX(this.getWidth()*(pos));
    }

    public boolean lessThan(RectangleClass rect){
            if(rect==null || this.getId() == null){
                return false;
            }
            if(this.getIntId()<rect.getIntId()){
                return true;
            }
            return false;
        }

        public boolean lessThanOrEqualTo(RectangleClass rect){
        if(rect==null || this.getId() == null){
            return false;
        }
        if(this.getIntId()<=rect.getIntId()){
            return true;
        }
        return false;
    }

        public boolean greaterThan(RectangleClass rect){
            if(rect==null || this.getId() == null){
                return false;
            }
            if(this.getIntId()>rect.getIntId()){
                return true;
            }
            return false;
        }

        public boolean greaterThanOrEqualTo(RectangleClass rect){
            if(rect==null || this.getId() == null){
                return false;
            }
            if(this.getIntId()>=rect.getIntId()){
                return true;
            }
            return false;
        }

        public boolean equalTo(RectangleClass rect){
            if(rect==null || this.getId() == null){
                return false;
            }
            if(this.getIntId()==rect.getIntId()){
                return true;
            }
            return false;
        }

        public int getIntId(){
            return Integer.parseInt(this.getId());
        }

    public void setStandartColor() {
        this.setFill(Color.web("#2C3639"));
    }
}
