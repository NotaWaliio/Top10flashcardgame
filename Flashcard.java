/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djpsproj;

/**
 *
 * @author Gus Guidotti
 */
public class Flashcard {
    
    private String back,front,img;

    public String getImg() {
        return img;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
    
    public Flashcard(String a, String b, String c){
        this.back = b;
        this.front = a;
        this.img = c;
    }
    
    
    
    
}
