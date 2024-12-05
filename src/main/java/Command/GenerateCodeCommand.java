package Command;

public class GenerateCodeCommand implements Command {
    private final PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        int[][] currentGrid = grid.getGrid();
        StringBuilder code = new StringBuilder("int[][] pixelArt = {\n");
        for (int[] row : currentGrid) {
            code.append("    {");
            for (int cell : row) {
                code.append(cell).append(", ");
            }
            code.setLength(code.length() - 2);
            code.append("},\n");
        }
        code.setLength(code.length() - 2);
        code.append("\n};");
        System.out.println(code);
    }
}
