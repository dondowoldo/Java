import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Integer divisor = null;
    Double base = null;

    while (divisor == null || base == null) {
      try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Divisor");
        divisor = scanner.nextInt();

        System.out.println("Base");
        base = scanner.nextDouble();

        // throws NullPointerException if divisor is 0
        System.out.println(divideByTryCatch(divisor, base));
        // throws ArithmetichException if divisor is 0
        System.out.println(divide(divisor, base));
      } catch (InputMismatchException exception) {
        System.out.println("Dej nám správný číslo");

      } catch (NullPointerException exception) {
        System.out.println("Děleno nulou");

      } catch (Exception exception) {
        System.out.println("Jsem ta nejobecnější výjimka co existuje");

      } finally {
        System.out.println("Já se stanu vždycky!");
      }
    }
  }

  /**
   * This way, IDE will show me what runtime exceptions are thrown from my own methods
   * @throws ArithmeticException if divisor is 0
   */
  public static Double divide(int divisor, double base) {
    if (divisor == 0) {
      throw new ArithmeticException("Cant divide by 0");
    }
    return base / divisor;
  }


  public static Double divideByTryCatch(int divisor, double base) {
    System.out.println("Třeba se spojuji z databází");
    try {
      return base / divisor;
    } catch (ArithmeticException e) {
      throw new NullPointerException("Cant divide by 0");
    } finally {
      System.out.println("Vypínám spojení s databází");
    }
  }


}
