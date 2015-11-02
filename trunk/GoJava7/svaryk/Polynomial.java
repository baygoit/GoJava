public class Polynomial {

    private int[] coefficients;
    private int actualdegree;

    /**
     * Creates a polynomial a * x^b.
     *
     * @param deg
     *            The degree of the polynomial.
     */
    public Polynomial(int a, int b) {

        this(b);
        this.setCoefficient(b, a);

        updateDegree(); // called whenever coefficients is changed

    }

    /**
     * Creates a polynomial of degree deg, with coefficients equal to zero.
     *
     * @param deg
     *            The degree of the polynomial.
     */
    public Polynomial(int deg) {

        if (deg < 0) {
            System.out.println("Polynomial degree must not be negative");
            System.exit(1);
        }

        coefficients = new int[deg + 1];

        updateDegree(); // called whenever coefficients is changed

    }

    /**
     * Creates a polynomial with coefficients from the coeffs array.
     *
     * @param coeffs
     *            An array of the coefficients for the polynomial, the first
     *            element is degree zero.
     */
    public Polynomial(int[] coeffs) {

        coefficients = (int[]) coeffs.clone();

        updateDegree(); // called whenever coefficients is changed

    }

    /**
     * Retrieves the degree of the polynomial. This is the maximum degree that
     * has been set, regardless whether that degree is zero.
     *
     * @return The degree of the polynomial.
     */
    public int getDegree() {

        return coefficients.length - 1;

    }

    /**
     * Retrieves the degree of the polynomial. This is the value of the degree
     * of the maximum non-zero coefficient.
     *
     * @return The degree of the polynomial.
     */
    public int getActualDegree() {

        return actualdegree;

    }

    /**
     * This function is called whenever the coefficients array is changed,
     * updates the internal value of the degree.
     */
    private void updateDegree() {

        for (int i = coefficients.length - 1; i >= 0; i--)
            if (coefficients[i] != 0) {
                actualdegree = i;
                return;
            }

        actualdegree = 0; // catch case where all-zero coefficients

    }

    /**
     * Retrieves a specific coefficient of the polynomial.
     *
     * @param r
     *            The degree of the coefficient to return. If this is out of the
     *            range, zero is returned.
     * @return The coefficient for the degree specified.
     */
    public int getCoefficient(int r) {

        if (r > getDegree() || r < 0)
            return 0;

        return coefficients[r];

    }

    /**
     * Sets the coefficient for a specific degree of the polynomial.
     *
     * @param r
     *            The degree to set, must be non-negative. If it is greater than
     *            the current degree, the polynomial's coefficients will be
     *            expanded to suit.
     * @param value
     *            The value of the new coefficient.
     */
    public void setCoefficient(int r, int value) {

        if (r < 0) {
            System.out.println("Invalid degree for setCoefficient");
            return;
        }
        if (r > getDegree()) { // out of range, must extend the array

            int newlength;

            newlength = Math.max(coefficients.length, r + 1);

            int[] newcoeffs = new int[newlength];

            for (int i = 0; i < coefficients.length; i++)
                newcoeffs[i] = coefficients[i];

            newcoeffs[r] = value;
            coefficients = newcoeffs;
        } else
            // within range, can just set the value
            coefficients[r] = value;

        updateDegree(); // called whenever coefficients is changed

    }

    /**
     * Evaluates the polynomial at a certain real value.
     *
     * @param x
     *            The value to evaluate the polynomial at.
     * @return The value of the polynomial at x.
     */
    public double evaluate(double x) {

        double sum = 0;

        for (int i = 0; i < coefficients.length; i++)
            sum += (double) coefficients[i] * Math.pow(x, i);

        return sum;

    }

    /**
     * Evaluates the polynomial at a certain polynomial, ie f(g(x))
     *
     * @param other
     *            The polynomial to evaluate this polynomial at.
     * @return The polynomial other evaluted at this polynomial.
     */
    public Polynomial evaluate(Polynomial other) {

        Polynomial output;

        output = new Polynomial(other.getDegree() * this.getDegree());

        for (int a = 0; a <= other.getActualDegree(); a++)
            output = output.add(this.powerOf(a).scalarmul(
                    other.getCoefficient(a)));

        return output;

    }

    /**
     * Creates a new polynomial with the same coefficients as this polynomial.
     *
     * @return A new polynomial with the same values as the current.
     */
    public Polynomial clonePoly() {

        return new Polynomial(coefficients);

    }

    /**
     * Adds two polynomials.
     *
     * @param other
     *            A polynomial to add to this polynomial.
     * @return A new polynomial which is the sum of this and other.
     */
    public Polynomial add(Polynomial other) {

        Polynomial large, small, output;

        if (other.getActualDegree() > getActualDegree()) {
            large = other;
            small = this;
        } else {
            large = this;
            small = other;
        }

        output = large.clonePoly();

        for (int i = 0; i <= small.getActualDegree(); i++)
            output.setCoefficient(i, output.getCoefficient(i)
                    + small.getCoefficient(i));

        return output;

    }

    /**
     * Subtracts a polynomial from this polynomial.
     *
     * @param other
     *            A polynomial to subtract from this polynomial.
     * @return A new polynomial which is this polynomial subtract other.
     */
    public Polynomial subtract(Polynomial other) {

        return this.add(other.scalarmul(-1));

    }

    /**
     * Multiplies a polynomial by this polynomial.
     *
     * @param other
     *            A polynomial to multiply by this.
     * @return A new polynomial which is the multiple of this and other.
     */
    public Polynomial multiply(Polynomial other) {

        Polynomial output;

        output = new Polynomial(other.getDegree() + this.getDegree());

        for (int a = 0; a <= this.getActualDegree(); a++)
            for (int b = 0; b <= other.getActualDegree(); b++)
                output.setCoefficient(a + b, output.getCoefficient(a + b)
                        + other.getCoefficient(b) * this.getCoefficient(a));

        return output;

    }

    /**
     * Multiplies this polynomial by a scalar.
     *
     * @param k
     *            A real value to multiply this by.
     * @return A new polynomial which is the multiple of this and k.
     */
    public Polynomial scalarmul(int k) {

        Polynomial output;

        output = new Polynomial(getDegree());

        for (int i = 0; i <= getActualDegree(); i++)
            output.setCoefficient(i, k * getCoefficient(i));

        return output;

    }

    /**
     * Raises this polynomial to a certain power.
     *
     * @param pow
     *            The power to raise the polynomial to. This should be a
     *            non-negative integer.
     * @return A new polynomial which is this polynomial raised to pow. If an
     *         error occurs (negative powers for example), null will be
     *         returned.
     */
    public Polynomial powerOf(int pow) {

        if (pow < 0) {
            System.out.println("Negative powers are not allowed");
            return null;
        }

        int[] one = { 1 };
        Polynomial output = new Polynomial(one); // this takes care of pow==0
        // case

        for (int i = 1; i <= pow; i++)
            output = output.multiply(this);

        return output;
    }

    /**
     * Divides two polynomials, returning the quotient.
     *
     * @param other
     *            A polynomial to divide this by. It should be monic, ie the
     *            coefficient of the highest power is equal to one.
     * @return A new polynomial which is this polynomial divided by other. If a
     *         divide by zero error occurs, null is returned.
     */
    public Polynomial quotient(Polynomial other) {

        return this.divide(other, true);

    }

    /**
     * Divides two polynomials, returning the remainder.
     *
     * @param other
     *            A polynomial to divide this by. It should be monic, ie the
     *            coefficient of the highest power is equal to one.
     * @return A new polynomial which is the remainder of dividing this by
     *         other. If a divide by zero error occurs, null is returned.
     */
    public Polynomial remainder(Polynomial other) {

        return this.divide(other, false);

    }

    /**
     * Divides this by another polynomial, returning either the quotient or the
     * remainder.
     *
     * @param div
     *            The polynomial to divide this polynomial by.
     * @param returnquotient
     *            If this is true, the quotient of the operation is returned. If
     *            it is false, the remainder of the operation is returned.
     * @return If quotient is true, the a new Polynomial representing the
     *         quotient of the operation is returned. Otherwise, a a new
     *         Polynomial representing the remainder is returned. If a divide by
     *         zero error occurs, null is returned.
     */
    private Polynomial divide(Polynomial div, boolean returnquotient) {

        int maxdeg = div.getDegree();

        if (maxdeg == 0) {
            System.out.println("Polynomial divide by zero error");
            return null;
        }

        // rem is the remainder "carried down" in long division
        Polynomial rem = this.clonePoly();
        // running is the "running total" of the quotient
        Polynomial running = new Polynomial(this.getDegree() - maxdeg);

        for (int i = this.getDegree(); i >= maxdeg; i--) {
            running.setCoefficient(i - maxdeg, rem.getCoefficient(i));
            rem = this.subtract(div.multiply(running));
        }

        if (returnquotient)
            return running;
        else
            return rem;

    }

    /**
     * Returns the derivative of the polynomial.
     *
     * @return A new polynomial which is the derivative of this polynomial.
     */
    public Polynomial derivative() {

        Polynomial output = new Polynomial(this.getDegree() - 1);

        for (int i = 1; i <= getActualDegree(); i++)
            output.setCoefficient(i - 1, this.getCoefficient(i) * i);

        return output;

    }

    public String toString() {
        if (this.getDegree() ==  0) return "" + coefficients[0];
        if (this.getDegree() ==  1) return coefficients[1] + "x " + ((coefficients[0] > 0) ? "+ " + coefficients[0] : (coefficients[0] == 0) ? "" : "- " + -coefficients[0]);
        String s = coefficients[this.getDegree()] > 0 ? coefficients[this.getDegree()] + "x^" + this.getDegree() : "";
        for (int i = this.getDegree()-1; i >= 0; i--) {
            if      (coefficients[i] == 0) continue;
            else if (coefficients[i]  > 0) s = s.equals("") ? s + ( coefficients[i]) : s + " + " + ( coefficients[i]);
            else if (coefficients[i]  < 0) s = s.equals("") ? s + ( coefficients[i]) : s + " - " + (-coefficients[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }

    public static void main(String[] args) {
        Polynomial p = new Polynomial(4, 3);
        Polynomial p2 = new Polynomial(3, 2);
        p = p.add(p2);
        System.out.println(p);
//              Polynomial p2 = new Polynomial(3);
//              p2.setCoefficient(3, 4);
//              p = p.add(p2);
//              System.out.println(p);
//              Polynomial q = new Polynomial(new int[]{-2, 1});
//              System.out.println(q);
//              System.out.println(p.divide(q, false));
    }
}
