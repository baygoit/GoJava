package education;

class TwoD {
    int x, y;

    TwoD(int a, int b) {
        x = a;
        y = b;
    }
}

class ThreeD extends TwoD {
    int z;

    ThreeD(int a, int b, int c) {
        super(a, b);
        z = c;
    }
}

class FourD extends ThreeD {
    int t;

    FourD(int a, int b, int c, int d) {
        super(a, b, c);
        t = d;
    }
}

class Coords<T extends TwoD> {  // <? super FourD>
    T[] coords;

    Coords(T[] o) {
        coords = o;
    }
}


class Demo {
    static void showXY(Coords<?> c) {
        for(int i = 0; i < c.coords.length; i++ ) {
            System.out.println(c.coords[i].x + "  " +
                               c.coords[i].y);
        }
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        for(int i = 0; i < c.coords.length; i++ ) {
            System.out.println(c.coords[i].x + "  " +
                               c.coords[i].y + "  " +
                               c.coords[i].z);
        }
    }

    static void showAll(Coords<? extends FourD> c) {
        for(int i = 0; i < c.coords.length; i++ ) {
            System.out.println(c.coords[i].x + "  " +
                    c.coords[i].y + "  " +
                    c.coords[i].z + "  " +
                    c.coords[i].t);
        }
    }

    public static void main(String[] args) {
        TwoD td[] = {new TwoD(0, 0), new TwoD(7, 9), new TwoD(18, 4), new TwoD(-11, -23)};
        Coords<TwoD> tdlocs = new Coords<TwoD>(td);
        showXY(tdlocs);
        //showXYZ(tdlocs);
        //showAll(tdlocs);

        FourD fd[] = {new FourD(1, 2, 3, 4),
                      new FourD(5, 6, 7, 8),
                      new FourD(9, 10, 11, 12),
                      new FourD(13, 14, 15, 16)};
        Coords<FourD> fdlocs = new Coords<FourD>(fd);
        //showXY(fdlocs);
        //showXYZ(fdlocs);
        //showAll(fdlocs);
    }
}
