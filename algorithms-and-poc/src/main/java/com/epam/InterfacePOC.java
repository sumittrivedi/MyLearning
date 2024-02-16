package com.epam;

public class InterfacePOC implements InterfaceA, InterfaceB {

    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(x);


        InterfaceA obj = new InterfacePOC();
        System.out.println(new InterfacePOC().getIndex());
        System.out.println(new InterfacePOC().getName());
        System.out.println(InterfaceA.staticIndex());
        System.out.println(InterfaceB.staticIndex());
        System.out.println(InterfacePOC.staticIndex());
    }

    @Override
    public int getName() {
        return 5;
    }

    @Override
    public int getIndex() {
        return InterfaceA.super.getIndex();
//        return 3;
    }

    //	@Override
    static int staticIndex() {
        return 33;
    }
}
