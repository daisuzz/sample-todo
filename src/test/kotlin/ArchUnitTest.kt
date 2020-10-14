import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import org.junit.jupiter.api.Test

class ArchUnitTest {

    @Test
    fun controllerはuseCaseに依存する() {

        val javaClasses = ClassFileImporter().importPackages("com.daisuzz.samplethymeleaftodo")

        val rule: ArchRule = layeredArchitecture()
                .layer("Controller").definedBy("..presentation..")
                .layer("UseCase").definedBy("..usecase..")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Controller")
        rule.check(javaClasses)
    }
}
