package com.eveliina.weatheroulu

data class TimePeriod(
    val beginPosition: String,
    val endPosition: String
)

data class TimeInstant(
    val timePosition: String
)

data class NamedValue(
    val nameHref: String,
    val value: String
)

data class Identifier(
    val codeSpace: String,
    val value: String
)

data class Location(
    val identifier: Identifier,
    val name: String,
    val geoid: String,
    val representativePointHref: String,
    val region: String
)

data class Point(
    val pos: String
)

data class MeasurementTVP(
    val time: String,
    val value: Float
)

data class MeasurementTimeseries(
    val points: List<MeasurementTVP>
)

data class FeatureOfInterest(
    val sampledFeature: Location,
    val shape: Point
)

data class Procedure(
    val href: String
)

data class ObservedProperty(
    val href: String
)

data class PointTimeSeriesObservation(
    val phenomenonTime: TimePeriod,
    val resultTime: TimeInstant,
    val procedure: Procedure,
    val parameter: NamedValue,
    val observedProperty: ObservedProperty,
    val featureOfInterest: FeatureOfInterest,
    val result: MeasurementTimeseries
)

data class Member(
    val pointTimeSeriesObservation: PointTimeSeriesObservation
)

data class WeatherResponse(
    val featureCollection: Any,
    val members: List<Member>,
    val timestamp: String,
    val numberMatched: Int,
    val numberReturned: Int,
    val location: Location,
    val temperature: Float,
    val humidity: Float,
    val windSpeed: Float
)






