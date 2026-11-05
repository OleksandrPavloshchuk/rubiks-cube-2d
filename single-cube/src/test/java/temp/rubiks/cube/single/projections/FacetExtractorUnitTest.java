package temp.rubiks.cube.single.projections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import temp.rubiks.cube.engine.model.Assembly;

public class FacetExtractorUnitTest {

    @Test
    void extract() {
        final Assembly assembly = new Assembly();

        final var actual = FacetExtractor.Y0.apply(assembly);

        Assertions.assertNotNull(actual);

        System.out.println( actual);
    }

}
