
object SpaceAge {

    val secondsInYear = 31557600

    def secondsToEarthYear(seconds: Double) = seconds / secondsInYear
    def round(n: Double) = (n * 100).round / 100.0
    def convertYears(seconds: Double, scale: Double) = round(secondsToEarthYear(seconds) / scale)

    def onEarth(seconds: Double) = convertYears(seconds, 1)
    def onMercury(seconds: Double) = convertYears(seconds, 0.2408467)
    def onVenus(seconds: Double) = convertYears(seconds, 0.61519726)
    def onMars(seconds: Double) = convertYears(seconds, 1.8808158)
    def onJupiter(seconds: Double) = convertYears(seconds, 11.862615)
    def onSaturn(seconds: Double) = convertYears(seconds, 29.447498)
    def onUranus(seconds: Double) = convertYears(seconds, 84.016846)
    def onNeptune(seconds: Double) = convertYears(seconds, 164.79132)
}