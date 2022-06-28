abstract class AbstractShapes {

    public abstract float printArea(float diameter);
    //public abstract float printArea(float width,float height);
}

public class circle extends AbstractShapes{
    final float PI = 3.14159265f;
    public float printArea(float diameter){return this.PI * diameter*diameter / 4;}
}

public class triangle extends AbstractShapes{
    public float printArea(float width){
        return width;
    }
}