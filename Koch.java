/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {
        if (args.length > 0) {
            snowFlake(Integer.parseInt(args[0]));
        }
    }

    /** Draws a Koch curve of depth n from (x1,y1) to (x5,y5). */
    public static void curve(int n, double x1, double y1, double x5, double y5) {
        if (n == 0) {
            StdDraw.line(x1, y1, x5, y5);
            return;
        }

        // 1. חישוב נקודות השליש
        double x2 = x1 + (x5 - x1) / 3.0;
        double y2 = y1 + (y5 - y1) / 3.0;
        double x4 = x1 + 2.0 * (x5 - x1) / 3.0;
        double y4 = y1 + 2.0 * (y5 - y1) / 3.0;

        // 2. חישוב הקודקוד p3 לפי הנוסחה המדויקת מהמטלה
        // הנוסחה הזו מחשבת את p3 כך שיצור משולש שווה צלעות מעל הקטע האמצעי
        double sin60 = Math.sqrt(3) / 2.0;
        double cos60 = 0.5;
        
        // גרסה מפוסקת וברורה של הנוסחה שקיבלת:
        double x3 = (cos60 * (x4 - x2)) - (sin60 * (y4 - y2)) + x2;
        double y3 = (sin60 * (x4 - x2)) + (cos60 * (y4 - y2)) + y2;

        // 3. ארבע קריאות רקורסיביות לפי הסדר
        curve(n - 1, x1, y1, x2, y2);
        curve(n - 1, x2, y2, x3, y3);
        curve(n - 1, x3, y3, x4, y4);
        curve(n - 1, x4, y4, x5, y5);
    }

    public static void snowFlake(int n) {
        StdDraw.clear();
        // הגדרת קודקודים למשולש שווה צלעות גדול
        // סדר הנקודות (עם כיוון השעון) יקבע אם השפיצים פונים החוצה
        double x1 = 0.2, y1 = 0.25;
        double x2 = 0.5, y2 = 0.25 + (Math.sqrt(3)/2.0) * 0.6;
        double x3 = 0.8, y3 = 0.25;

        // ציור שלוש הצלעות של פתית השלג
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}