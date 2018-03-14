package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.MyRectangle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.ImpossibleMovement;

import java.util.ArrayList;

/**
 * Klasa odpowiedzialna za rozpoznanie akcji związanej z kliknięciem myszką na kwadracik bądź kulkę
 */
public class MauseClickOnRectangleOrCircle {
    public void body(MyRectangle rectangle, ArrayList<Circle> listCircle, ArrayList<MyRectangle> listRectangle, Color[] listColor, ArrayList<Circle> smallListCircle, Pane pane, Label points,Label statement){
        boolean flag = false;
        boolean flagC = false;
        boolean flagM = false;
        for (Circle circle: listCircle){
            if(rectangle.getRectangle().getX()+20==circle.getTranslateX() && rectangle.getRectangle().getY()+20 == circle.getTranslateY() && rectangle.getRectangle().getFill().equals(Color.BLUE)){
                for(MyRectangle rec: listRectangle){
                    if(rec.getRectangle().getFill().equals(Color.KHAKI)){
                        rec.getRectangle().setFill(Color.BLUE);
                    }
                }
                rectangle.getRectangle().setFill(Color.KHAKI);
                listRectangle.set(rectangle.getId(),rectangle);
                flag=true;
            }
            if(rectangle.getRectangle().getX()+20==circle.getTranslateX() && rectangle.getRectangle().getY()+20 == circle.getTranslateY()){
                flagC=true;
            }
        }
        for(MyRectangle rec : listRectangle){
            if(rec.getRectangle().getFill().equals(Color.KHAKI) && flag==false && flagC==false){
                flagM =true;
                MovementInTheGame movementInTheGame = new MovementInTheGame();
                movementInTheGame.movementInTheGame(rec,rectangle,listCircle,listColor,listRectangle,smallListCircle,pane,points,statement);
            }
        }
        if(!flagM && !flag && !flagC){
            try {
                throw new ImpossibleMovement(statement);
            } catch (ImpossibleMovement impossibleMovement) {
            }
        }
    }
    public void mauseClickOnRectangle(MyRectangle rectangle, ArrayList<Circle> listCircle, ArrayList<MyRectangle> listRectangle, Color[] listColor, ArrayList<Circle> smallListCircle, Pane pane,Label points,Label statement){
        rectangle.getRectangle().setOnMouseClicked(new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent t) {
        body(rectangle, listCircle, listRectangle, listColor, smallListCircle, pane,points,statement);
    }});
}
    public void mauseClickOnCircle(MyRectangle rectangle, ArrayList<Circle> listCircle, ArrayList<MyRectangle> listRectangle, Color[] listColor, ArrayList<Circle> smallListCircle, Pane pane, Circle circle,Label points, Label statement){
        circle.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                body(rectangle, listCircle, listRectangle, listColor, smallListCircle, pane,points,statement);
            }});
    }
}
