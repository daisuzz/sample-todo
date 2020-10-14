import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.junit.jupiter.api.Test

class ArchUnitTest {

    @Test
    fun ControllerはUseCaseに依存する(){

        val javaClasses = ClassFileImporter().importPackages("com.daisuzz.samplethymeleaftodo")

        classes()
    }
}
