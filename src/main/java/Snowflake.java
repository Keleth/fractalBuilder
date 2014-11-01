import org.omg.CORBA.SystemException;

import java.awt.*;

/**
 * Created by Keleth on 01.11.14.
 */
public class Snowflake extends Canvas {

    private static final long serialVersionUUID = 456645646587822L;
    private int angle;
    private int count;

    public void paint(Graphics g) {
        setBackground(Color.black);
        g.setColor(Color.blue);

        Point a = new Point(0, 10);
        Point b = new Point(getWidth(), 10);

        drawKochLine(g, a, b, angle, count);
    }

    /**
     * Рисует рекурсивно линию Коха. При этом отрезок (a; b) делится на 3 равных
     * части. Средняя из них заменяется равносторонним треугольником со стороной
     * равной данной и без данной стороны (рисуется только две, не принадлежащие
     * отрезку стороны треугольника).
     * @param g
     * @param a  начальная точка
     * @param b  конечная точка
     * @param fi угол поворота
     * @param n  глубина рекурсии
     */
    public void drawKochLine(Graphics g, Point a, Point b, double fi, int n) {

        if (n <= 0) {
            // прямая, рекурсия закончена
            g.drawLine(a.x, a.y, b.x, b.y);
        } else {
            // узнаем длину отрезка а - б
            double length = Math.pow(Math.pow(b.y - a.y, 2) + Math.pow(b.x - a.x, 2), 0.5);
//            System.out.println("Length: ".concat(Double.toString(length)));
            // длина 1/3 отрезка
            double lengthOf3 = length / 3;
//            System.out.println("1/3 length: ".concat(Double.toString(lengthOf3)));

            // Точка первой трети
            Point a1 = new Point(a.x + (int) Math.round(lengthOf3 * Math.cos(fi)),
                                 a.y + (int) Math.round(lengthOf3 * Math.sin(fi)));

            // Точка второй трети
            Point b1 = new Point(a1.x + (int) Math.round(lengthOf3 * Math.cos(fi)),
                                 a1.y + (int) Math.round(lengthOf3 * Math.sin(fi)));

            // Найти точку для вершины равностороннего треугольника
            Point c = new Point(a1.x + (int) Math.round(lengthOf3 * Math.cos(fi + Math.PI / 3)),
                                a1.y + (int) Math.round(lengthOf3 * Math.sin(fi + Math.PI / 3)));

            n--;
            drawKochLine(g, a1, c, fi + Math.PI / 3, n);
            drawKochLine(g, c, b1, fi - Math.PI / 3, n);

            n--;
            drawKochLine(g, a, a1, fi, n);
            drawKochLine(g, b1, b, fi, n);
        }
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
