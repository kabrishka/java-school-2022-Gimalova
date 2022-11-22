package ru.croc.task56;

public class Task56 {
    public static void main(String[] args) {
        try {
            //тесты
            Annotation[] annotations = new Annotation[2];
            annotations[0] = new Annotation("Car", new Rectangle(100,100,250,200));
            annotations[1] = new Annotation("Tree", new Circle(1000,1000,10));

            AnnotatedImage img = new AnnotatedImage("some/path.txt", annotations);

            for(Annotation annotation : annotations) {
                System.out.println(annotation.toString());
            }

            System.out.println("Find position by point: ");
            System.out.println(img.findByPoint(2500,200).toString());

            System.out.println("Find position by label: ");
            System.out.println(img.findByLabel("T").toString());

            annotations[1].getFigure().move(5,6);
            annotations[0].getFigure().move(4,7);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
