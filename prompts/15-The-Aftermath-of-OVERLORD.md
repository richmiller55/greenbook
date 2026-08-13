# Chapter 15: The Aftermath of OVERLORD

## 1. Context & Core Themes
Following the successful landings on June 6, 1944, the Allies faced the critical task of sustaining the breakout. Planners wrestled with the destruction of the Mulberry harbor at Omaha beach by a severe storm, the slow capture of Cherbourg, and the creation of the famous "Red Ball Express" truck convoy system to chase the rapid breakout.

---

## 2. Interactive Study Fill-ins (Details to Fill In)
*To complete your study of this chapter, research and fill in the missing metrics below:*

- **Post-Invasion Logistics:**
  - The severe storm of June `[___________]` completely destroyed the American Mulberry harbor ("Mulberry A") at Omaha Beach.
  - The Red Ball Express was established on August 25, 1944, and operated a fleet of `[___________]` trucks at its peak.
  - The daily fuel requirement for a rapid pursuit division in August 1944 was approximately `[___________]` gallons of gasoline.

---

## 3. Logistical Architecture (Mermaid.js Diagram)
Complete or extend this diagram depicting the logistical workflows, command hierarchies, or pipelines of this chapter.

```mermaid
graph TD
    Normandy_Beaches[Normandy Beaches / Cherbourg] -- "Red Ball Express" --> Front_Line[Third & First Army Depots]
    Red Ball Express --> OneWayLoop[One-Way Loop Highway]
    OneWayLoop --> VehicleMaintenance[Field Maintenance Depots]
```

---

## 4. Quantitative Modeling: The Aftermath of OVERLORD
The Red Ball Express is a network flow problem. The maximum daily tonnage ($T_{max}$) delivered is bounded by the number of operational trucks, fuel consumption of the fleet, and road congestion limits.

### Mathematical Formulation
$T_{max} = \frac{N \cdot P_{payload}}{2 \cdot (D / V + T_{load})}$

### Scala 3.8.3 Implementation
Below is the compile-safe Scala 3.8.3 model representing these parameters:

```scala
package Logistics.OverlordAftermath

case class FleetConfig(trucks: Int, payloadTons: Double)

object NetworkFlowSolver:
  def maxDailyTonnage(
    config: FleetConfig,
    oneWayDistanceMiles: Double,
    averageSpeedMph: Double,
    loadingTimeHours: Double
  ): Double =
    val transitTimeHours = oneWayDistanceMiles / averageSpeedMph
    val roundTripTimeHours = 2.0 * (transitTimeHours + loadingTimeHours)
    val tripsPerDay = 24.0 / roundTripTimeHours
    config.trucks * config.payloadTons * tripsPerDay
```

---

## 5. Strategic Discussion Questions
1. How did the loss of the Omaha Mulberry harbor alter the planned Allied supply schedule, and what alternative methods proved surprisingly successful?
2. Analyze the logistical cost of the rapid breakout (pursuit) across France, focusing on the point where the consumption of fuel by supply trucks exceeded the delivery to combat units.
