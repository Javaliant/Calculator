/* Author: Luigi Vincent
enum to compute calculator calculations
*/

public enum Operation implements Equation {
	ADD((x, y) -> x + y),
	SUBTRACT((x, y) -> x - y),
	MULTIPLY((x, y) -> x * y),
	DIVIDE((x, y) -> x / y),
	MOD((x, y) -> x % y),
	EXPONENTIATE(Math::pow);

	private final Equation equation;

	Operation(Equation equation) {
		this.equation = equation;
	}

	@Override
	public double compute(double alpha, double beta) {
		return equation.compute(alpha, beta);
	}

	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}
}
