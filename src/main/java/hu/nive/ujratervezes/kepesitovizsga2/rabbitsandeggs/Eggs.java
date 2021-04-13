package hu.nive.ujratervezes.kepesitovizsga2.rabbitsandeggs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class Eggs {

    public Rabbit getRabbitWithMaxEggs(){
        try(Stream<String> fs = Files.lines(Path.of("src/main/resources/eggs.csv"))){

            return fs.map(s->s.split(";"))
                    .map(s->new Rabbit(s[0],Integer.parseInt(s[1])))
                    .max(Comparator.comparing(Rabbit::getEggs)).orElse(null);

        }catch (IOException ioe){
            throw new IllegalStateException("Can not load data from file",ioe);
        }
    }
}
