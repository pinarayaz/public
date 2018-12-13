package ch.epfl.sweng.dp1.ex6;

public class StarkHouse implements House {
    @Override
    public Member createMember() {
        return new StarkMember();
    }

    @Override
    public Bastard createBastard() {
        return new StarkBastard();
    }
}
