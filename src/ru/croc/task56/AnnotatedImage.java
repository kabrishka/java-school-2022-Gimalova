package ru.croc.task56;

/*
 * Класс аннотированного изображения
 */

public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    /*
     * Выбор аннотации по координатам точки (x, y)
     *
     * @int x - координата точки
     * @int y - координата точки
     * @return объект класса Annotation
     *
     * В массиве аннотаций производится поиск первой фигуры, которая содержит точку с заданными координатами
     */
    public Annotation findByPoint(int x, int y) {
        for(Annotation annotation : annotations) {
            if(annotation.getFigure().containsPoint(x, y)) {
                return annotation;
            }
        }
        return null;
    }

    /*
     * Выбор аннотации по шаблону подписи
     *
     * @String label - подпись
     * @return объект класса Annotation
     *
     * В массиве аннотаций производится поиск первой подписи, которая содержит заданную подстроку.
     */
    public Annotation findByLabel(String label) {
        Annotation findAnnotation = new Annotation();
        for(Annotation annotation : annotations) {
            if(annotation.getSignature().contains(label)) {
                findAnnotation = annotation;
                break;
            }
        }
        return findAnnotation;
    }
}
