import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BeerSong{
    String sing(int bottle, int verses){
        return IntStream.iterate(bottle, i -> i -1)
                .limit(verses)
                .mapToObj(Bottle::of)
                .map(Bottle::verse)
                .collect(Collectors.joining(""));
    }
    String singSong(){
        return sing(99, 100);
    }
}

class Bottle {
    static Bottle of(int quantity){
        if (quantity == 0) return new ZeroBottle();
        if (quantity == 1) return new OneBottle();
        return new NBottle(quantity);
    }
    String firstLine(){
        var str = String.format("%s of beer on the wall, %s of beer.\n", this, this);
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    String secondLine(){return "";}
    String verse(){
        return firstLine().concat(secondLine());
    }
}
class ZeroBottle extends Bottle {
    public String toString(){
        return "no more bottles";
    }
    String secondLine(){
        return String.format("Go to the store and buy some more, %s of beer on the wall.\n\n", Bottle.of(99));
    }
}
class OneBottle extends Bottle {
    public String toString(){
        return "1 bottle";
    }
    String secondLine(){
        return String.format("Take it down and pass it around, %s of beer on the wall.\n\n", Bottle.of(0));
    }
}
class NBottle extends Bottle {
    int quantity;
    NBottle(int quantity) { this.quantity = quantity; }
    public String toString(){
        return String.format("%d bottles", quantity);
    }
    String secondLine(){
        return String.format("Take one down and pass it around, %s of beer on the wall.\n\n", Bottle.of(quantity - 1));
    }
}