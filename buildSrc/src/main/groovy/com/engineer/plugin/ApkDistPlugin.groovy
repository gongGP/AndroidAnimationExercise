import org.gradle.api.Plugin
import org.gradle.api.Project

class ApkDistPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {

        target.extensions.create('apkconfig', ApkDistExtension)


        target.afterEvaluate {


            println "===================================plugin===============begin=================="

            if (!target.android) {
                throw new IllegalStateException('Must apply \'com.android.application\' or \'com.android.library\' first!')
            }

            if (target.apkconfig.nameMap == null || target.apkconfig.destDir == null) {
                target.logger.info('Apk dist conf should be set!')
                return
            }

            Closure nameMap = target['apkconfig'].nameMap
            String destDir = target['apkconfig'].destDir

//            target.android.applicationVariants.all { variant ->
//                variant.outputs.all {
//                    nameMap(outputFileName)
//                    variant.getPackageApplication().outputDirectory = new File(destDir, variant.name)
//                }
//            }

            def releaseTime = new Date().format("yyyy_MM_dd_HH_mm", TimeZone.getTimeZone("GMT+08:00"))

            target.android.applicationVariants.all { variant ->
                println("variant=== ${variant.name} ${variant.versionName}")
                variant.outputs.all {

                    outputFileName = "animation_${variant.versionName}_${releaseTime}_${variant.name}.apk"
                    nameMap(outputFileName)
//                    variant.getPackageApplication().outputDirectory = new File(destDir, variant.name)
                }
            }
            println "===================================plugin===============end=================="

        }


    }
}