package com.gamovation.baselineprofile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This test class generates a basic startup baseline profile for the target package.
 *
 * We recommend you start with this but add important user flows to the profile to improve their performance.
 * Refer to the [baseline profile documentation](https://d.android.com/topic/performance/baselineprofiles)
 * for more information.
 *
 * You can run the generator with the Generate Baseline Profile run configuration,
 * or directly with `generateBaselineProfile` Gradle task:
 * ```
 * ./gradlew :app:generateReleaseBaselineProfile -Pandroid.testInstrumentationRunnerArguments.androidx.benchmark.enabledRules=BaselineProfile
 * ```
 * The run configuration runs the Gradle task and applies filtering to run only the generators.
 *
 * Check [documentation](https://d.android.com/topic/performance/benchmarking/macrobenchmark-instrumentation-args)
 * for more information about available instrumentation arguments.
 *
 * After you run the generator, you can verify the improvements running the [StartupMeasureBenchmark] benchmark.
 **/
@RunWith(AndroidJUnit4::class)
@LargeTest
@RequiresApi(Build.VERSION_CODES.P)
class BaselineProfileGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    @Test
    fun generate() {
        rule.collect("com.gamovation.tilecl", includeInStartupProfile = true) {
            pressHome()
            startActivityAndWait()

            Thread.sleep(3000)
            device.findObject(By.desc("RequestNotificationPermissionYesTag"))
                ?.clickAndWait(Until.newWindow(), 5000)
            Thread.sleep(3000)

            device.findObject(By.desc("StoreScreenNavigate"))
                .clickAndWait(Until.newWindow(), 5000)
            device.findObject(By.desc("StoreLazyColumn"))
                .also {
                    it?.fling(Direction.DOWN)
                    it?.fling(Direction.UP)
                }
            device.pressBack()
            pressHome()
            startActivityAndWait()

            device.findObject(By.desc("MenuScreenNavigate"))
                .clickAndWait(Until.newWindow(), 5000)
            device.findObject(By.desc("MenuLazyColumn"))
                .also {
                    it?.fling(Direction.DOWN)
                    it?.fling(Direction.UP)
                }

            device.pressBack()
            pressHome()
            startActivityAndWait()
            device.pressBack()
            pressHome()
            startActivityAndWait()
            device.wait(Until.hasObject(By.desc("LevelScreenFastNavigate")), 10000L)
            device.findObject(By.desc("LevelScreenFastNavigate"))
                .clickAndWait(Until.newWindow(), 5000)
        }
    }
}
