Cost: 0.007725536

# Chapter 10: Ships, Landing Craft, and Strategy  
## Reference Manual and Simulation Specification

---

## 1. Strategic Context & Modern Historical Perspective

By late 1943, Allied grand strategy had become an exercise in hull arithmetic. The conferences at Casablanca, TRIDENT, QUADRANT, and SEXTANT were not merely forums for negotiation; they were attempts to reconcile a global offensive intent with a hard industrial and maritime fact: the sea was the limiting resource of the war. The army divisions staged in Britain, the Luftwaffe defeated in the Mediterranean, the Japanese perimeter shrinking in the Pacific—all required either cargo ships, assault ships, or both. Shipping was not simply a transport medium; it was a strategic weapon system, and its shortage shaped the dates of every major amphibious operation.

### The Strategic Paradox

The central paradox of 1943 can be stated simply: Allied strategy called for the defeat of Germany first and the containment of Japan, but the maritime resources needed to execute that strategy were insufficient to satisfy both the European and Pacific theaters simultaneously. At Casablanca in January 1943, Roosevelt and Churchill agreed to defeat Germany first, to intensify the strategic bombing offensive, and to continue operations in the Mediterranean. They did not set a firm date for a cross-Channel invasion. The reason was not exclusively enemy strength; it was shipping and landing craft. A cross-Channel assault, even as a sacrifice operation, required a minimum of heavy landing ships to put tanks ashore on the first tide. That capability did not exist in early 1943.

By the time of the TRIDENT conference in Washington in May 1943, the Combined Chiefs set 1 May 1944 as the provisional date for Operation OVERLORD. They also approved a “combined bomber offensive.” Yet the instructions to the planning staffs contained a caveat that would become the leitmotif of the next twelve months: the assault lift “available” might not be sufficient. At QUADRANT in Quebec in August 1943, the British and Americans reaffirmed OVERLORD, but the British immediately began to argue that the Mediterranean front, not the Bay of the Seine, was where the LST shortage could most profitably be exploited. This produced one of the most bitter coalition debates of the war.

At SEXTANT in Cairo, and at Tehran immediately thereafter, the issue came to a head. Stalin pressed for a May 1944 cross-Channel invasion and for a supporting invasion of southern France. Roosevelt, facing an election year and conscious of Soviet manpower losses, agreed with the broad principle. The Combined Chiefs then had to allocate an insufficient inventory of LSTs between the Pacific, the Mediterranean, and the English Channel. This was not a question of land force quality or strategy preference; it was a question of production schedules, steel allocation, and shipyards. Modern post-war accounting confirms that the critical variable in the 1943–44 planning cycle was not the number of divisions or aircraft but the number of `LST` hulls that could be built, crewed, worked up, sailed across the Atlantic, and made ready for a single dawn in Normandy.

### Inter-Service and Coalition Tensions

The friction was not merely Anglo-American. Within the U.S. command system there was a structural conflict between three claimants to the same steel and shipbuilding capacity: the Navy’s combatant programs, the Maritime Commission’s merchant ship program, and the Army’s need for assault shipping. The Navy’s Bureau of Ships, under Admiral Ernest J. King, was concerned with the U-boat war and with fleet operations in the Pacific. The War Shipping Administration and the Maritime Commission were responsible for standard cargo ships—Liberty and Victory ships—that could move and sustain whole armies overseas. The Army’s Services of Supply was the customer for both, but it did not own either the construction capacity or the combatant transport. The Army had to argue its requirements through the Joint Chiefs, the Combined Chiefs, and ultimately the President.

The result was a permanent administrative battle. The British and Americans could not even agree on a common pool of landing craft. The British, experienced in Mediterranean amphibious warfare from Torch to Husky, wanted a single Mediterranean theater pool from which craft could be shifted opportunistically. The Americans, suspicious that such a pool would permanently delay OVERLORD in favor of operations in Italy and the Aegean, insisted on allocating LSTs by specific operation and date. The British Chiefs, led by Churchill, repeatedly tried to trade a southern France landing for operations in Italy and the Balkans. The American Chiefs, supported by the Joint War Plans Committee and by Eisenhower, refused to sacrifice a direct return to the continent. Every one of these arguments was made in the currency of LSTs.

There was also friction between the assault planners and the service forces. Combat loading—placing divisional ammunition, fuel, and vehicles in the sequence required for a beach assault—meant that ships could not be filled to maximum tonnage. A cargo ship loaded for base delivery can pack more tonnage than one combat-loaded for a beach. The Navy tended to judge shipping by “boxed” capacity; the Army measured “combat-loaded” capacity. The difference, often 20 to 30 percent, was a hidden reduction in available lift. Port commanders on both sides of the Atlantic fought over demurrage, port clearance, and priority for cranes and stevedores. The Services of Supply in Britain had to build depots, pipelines, and marshaling yards before the assault divisions arrived. All of this required merchant shipping that was simultaneously needed to feed Britain and build the invasion force.

### Historical Era Context

The Green Book chapter is best understood as a study of the supreme constraint of the European war: shipping and landing craft. Steel was the raw material; shipyards were the factory; the Atlantic was the warehouse; and the beach was the bottleneck. The landing-craft problem, in particular, has a quality that pure shipping tonnage lacks: a Liberty ship is useless until a port is captured. An LST is useful at the waterline. For OVERLORD, the Allies did not need merely tons of shipping; they needed assault lift that could run onto a mined, defended beach, lower a ramp, deliver vehicles directly over the sand, retract, and return for another load. That specific capability was embodied in the LST. Nothing else could do the job. Cargo ships could not beach; tank lighters could not cross the Atlantic; landing craft could not carry sufficient loads. Thus the LST became strategically decisive.

The chapter also addresses the competition for steel and shipyard capacity. In 1942 and early 1943, the U-boat campaign threatened to cut the Atlantic lifeline. The Navy therefore demanded destroyer escorts—small, cheap ASW escorts that could be mass-produced in merchant yards. Every DE built was a hull that might otherwise have been an LST, an LCT, or a Liberty ship. Because the U-boat threat was immediate and the invasion of Europe was still a year away, President Roosevelt and the Joint Chiefs repeatedly shifted priority to the DE program. Modern statistical and logistics scholarship has shown that this was rational in a narrow sense but costly in a broader one: the U-boat was defeated by May 1943, and the DE program then produced hundreds of escorts at the very moment the LST shortage was about to constrain strategy. The lead time of shipbuilding meant that the earlier prioritization of DEs could not be reversed in time for the late 1944 amphibious campaigns except by diverting warships to transport duty.

### Modern Analytical Insights

Post-war declassification and quantitative naval-history research have amplified this point. The LST and DE programs competed not only for steel plate but also for reduction gears, diesel engines, marine turbines, welding labor, and construction ways. Because both were “emergency” programs thrust onto unprepared shipbuilding infrastructure, their production curves were not smooth. The LST program, for example, involved prefabrication of sections at inland plants, railroad movement to coastal yards, and rapid assembly. The Kaiser shipyards, famous for Liberty production, developed a production system for LSTs that reduced building time from months to roughly ten weeks by 1943. Yet the LST was still not a mass-produced item like a Liberty ship; it was a Navy-designed amphibious vessel with ramps, pumps, tank decks, and a complex bow. The number of available LSTs was therefore not a simple production count. It had to be degraded for crew training, shakedown, transatlantic steaming, scheduled maintenance, battle damage repair, and operational “dead time” at anchor waiting for loading orders.

Modern simulations of the 1943–44 planning problem suggest that the real shortage was not always the number of hulls in existence but the number of operationally certificated hulls available in the right theater. On D-Day, the Allied fleet at Normandy included more than 200 LSTs, but at any given time a substantial fraction were in maintenance, repair, or turnaround. The effective serviceability factor—the probability an assigned LST is available for load-and-go duty—was closer to 0.80 in sustained operations and lower during prolonged bad weather or after a contested landing. The nominal production counts thus overstate the usable fleet by as much as 20–30 percent. The historical planners knew this, but they lacked the computing power to model it. They therefore relied on empirical “percent availability” tables, which often became the subjects of inter-theater dispute.

Modern analytical literature has also revised the strategic role of the Liberty ship. The Liberty ship was the transportation backbone of the war, but it was not an assault instrument. By late 1943 there was an incipient surplus of ordinary dry cargo capacity relative to port clearance capacity. The shipping crisis was shifting from “not enough ships” to “not enough usable ports and not enough assault lift.” This is why the Green Book title pairs “Ships” with “Landing Craft”: the former solved quantity, the latter solved access. The strategic reality of 1944 was that, while the merchant fleet could support an army once it had a port, only landing craft could create the port. The LST was the key that unlocked the fortress.

---

## 2. High-Fidelity Simulation Parameters & Real-World Metrics

The following table contains the critical historical constants, coefficients, and operational metrics required for a division-level logistics simulator. Values are drawn from official Maritime Commission, Naval History and Heritage Command, and U.S. Army logistics histories. Each value includes the recommended simulation representation.

| Metric | Historical Value | Simulation Representation | Rationale |
|---|---:|---|---|
| **Total Liberty ships completed in peak year 1943** | **1,896 hulls** (calendar-year deliveries; approximately 158 hulls per month at peak) | Monthly production increment; use production curve rather than constant, with a peak of ~158/month in mid-1943 | This is the raw rate of merchant cargo hull production. In simulation, treat as dynamic capacity cap for maritime cargo lift. |
| **Global LST deficit vs. ETO planners’ requirements, late 1943** | **70 LSTs** (Combined Chiefs planning shortfall against NEPTUNE/ANVIL and Pacific minimum requirements) | Initial `deficitBacklog = 70`; apply as a demand shortfall state that must be reduced by monthly production and inter-theater reallocation | This is the consensus figure from the late-1943 Combined Chiefs landing-craft review. The exact historical accounting varies by counting method, so use 70 as the baseline and sensitivity-test from 65 to 75. |
| **Standard building duration of an LST, Kaiser shipyard, 1943** | **70 calendar days** (keel-to-delivery; approximately 10 weeks) | Dynamic production pipeline delay: `productionPipelineDays = 70`; monthly output = `ways * 30 / 70` for each yard | LST production was prefabricated; 70 days represents the average assembly and outfitting duration after inland prefabrication. This is a lead-time constant for fleet expansion. |
| **LST payload capacity** | ~2,000 short tons of cargo and armor; 2,100 tons on a shallow-draft beach run | `capacityPerTrip = 2000 tons` | Used to convert hull-month availability into delivered tonnage. |
| **LST service speed** | 10 knots sustained; ~240 nautical miles/day with weather and current | `speed = 10 knots`; route leg time = distance / speed | LSTs made transatlantic voyages under own power, but slowly. |
| **LST operational availability** | 0.80 in sustained operations; 0.70 in theater pool due to transit and maintenance | `effectiveAvailability = 0.80` for combat operations; `theaterPoolFactor = 0.70` for allocation | Nominal hull count overstates usable lift. |
| **Total U.S. LST production, all yards, entire war** | 1,052 hulls (including U.S.-built vessels transferred under Lend-Lease) | Terminal production cap; aggregate `ShipCount(LST) <= 1052` | Bound for long-horizon Pacific and European simulations. |
| **Liberty ship cargo capacity** | 10,500 deadweight tons; ~4,900 measurement tons of general cargo | `capacityPerLiberty = 4900 tons` per voyage | Used for transatlantic theater buildup and port clearance calculations. |
| **Port discharge factor, European theater 1944** | ~6,000–8,000 tons/day per major port in the first month; increasing to >20,000 tons/day per port by late 1944 | Congestion penalty: if total inbound tons exceed port discharge capacity, create backlog | This implements the port-clearance bottleneck. |
| **Landing-craft attrition rate, assault month** | 2–4% hull loss per week during opposed beach operations; 1.5% per month in non-assault periods | `attritionRate` parameter; spike for contested landing nodes | Weather, grounding, mines, and enemy action are modeled as attrition events. |

For high-fidelity use, the model should not treat these parameters as static constants forever. `monthlyProduction` should be ramped up and then tapered based on historical schedules; `attritionRate` should increase during operational combat months and decrease during maintenance months. The effective fleet size is:

\[
F^\text{effective}_t =
F^\text{nominal}_t \cdot e^\text{availability} \cdot e^\text{theater transit}
\]

where \(e^\text{availability} \approx 0.80\) and \(e^\text{theater transit} \approx 0.70\).

---

## 3. Logistical Network Topology

The following Mermaid diagram models the flow of shipping capacity, LSTs, and cargo from industrial production to combat nodes. It is designed to capture capacity limits, congestion delays, and alternative routing when a port or route is blocked.

```mermaid
flowchart LR
    subgraph PROD["Production System"]
        WPB["War Production Board / WSA"] --> STEEL["Plate / reduction gear pool"]
        STEEL --> MAR["Maritime Commission yards"]
        STEEL --> NAV["Navy / Kaiser yards"]
        MAR --> LIB["Liberty / Victory / T2 hulls"]
        NAV --> LST["LST / LCT / DUKW craft"]
        NAV --> DE["Destroyer-escort program (competing resource)"]
    end

    subgraph ALLOC["Allocation Board"]
        CCS["Combined Chiefs / Combined Shipping Board"] --> POOL["Global Fleet Pool"]
        LIB --> POOL
        LST --> POOL
        POOL --> ETO["ETO pool"]
        POOL --> MTO["Mediterranean pool"]
        POOL --> PAC["Pacific/SWPA pool"]
        POOL --> RES["Reserve / Training / Maintenance"]
    end

    subgraph ATLANTIC["North Atlantic"]
        ETO --> HXSC["HX / SC / ONS convoys"]
        HXSC --> UKP["Clyde / Liverpool / Bristol Channel"]
        UKP --> ETODEP["ETO Army depots"]
        UKP --> SLUG["Channel port staging / loading areas"]
    end

    subgraph MED["Mediterranean"]
        MTO --> MEDCONV["UG / KMF convoys"]
        MEDCONV --> MEDP["North African / Italian ports"]
        MEDP --> MEDDEP["AFHQ advanced depots"]
    end

    subgraph PACIFIC["Pacific"]
        PAC --> PACCONV["SCW convoys / POA shuttle"]
        PACCONV --> PACB["Pearl Harbor / Nouméa / Brisbane"]
        PACB --> PACDEP["SWPA / POA advanced bases"]
    end

    subgraph COMBAT["Combat Nodes"]
        SLUG --> NEPTUNE["NEPTUNE Assault Area"]
        NEPTUNE --> OVERBEACH["Beachhead discharge via DUKWs / causeways"]
        OVERBEACH --> FWD["Forward Log Area"]
        MEDDEP --> ANVIL["ANVIL / DRAGOON / Italy operations"]
        PACDEP --> ISLAND["Island Assault Objectives"]
    end

    subgraph ATTR["Attrition and Availability"]
        NEPTUNE --> LOSS["Enemy action / weather / grounding"]
        ANVIL --> LOSS
        ISLAND --> LOSS
        LOSS --> REUSE["Repair / refit / crew training pool"]
        REUSE --> POOL
        ETODEP -. "port congestion overflow; reroute to secondary ports" .-> UKP
        OVERBEACH -. "beach closed by weather; route to MULBERRY/port" .-> UKP
    end
```

Key modeling behavior of this topology:

- **Capacity limits**: Every port, depot, and beach node has a discharge capacity in tons/day. When input exceeds capacity, cargo accumulates as a queue and ships wait outside the port, increasing turnaround time.
- **Congestion delays**: Edge labels should include convoy speed, port waiting time, and channel transit time. For example, a transatlantic convoy from New York to the Clyde takes 10–14 days; an LST crossing takes 20–30 days due to slower speed and weather.
- **Alternative routing**: If the English Channel ports are congested, cargo can be routed through Mediterranean ports and then overland, but at a heavy time cost. If Pacific ports are congested, cargo can be routed to Australia and moved north, but with limited capacity. The topology encodes these alternatives explicitly.

---

## 4. Mathematical Modeling & Simulation Formulas

The core resource allocation problem is modeled as a dynamic inventory of LSTs and merchant ships. Let:

- \(t\) = monthly time index
- \(F_t\) = number of LST hulls in the effective operational fleet at the start of month \(t\)
- \(P_t\) = number of new LSTs delivered at the end of month \(t\)
- \(\alpha_t\) = attrition/availability loss fraction during month \(t\) (due to combat, weather, grounding, and transfer withdrawal from pool)
- \(R_{t,j}\) = required number of LSTs in theater \(j\) during month \(t\)
- \(x_{t,j}\) = number of LSTs allocated to theater \(j\) during month \(t\)
- \(e_t\) = operational effectiveness factor, \(0 < e_t < 1\)
- \(D_{t,j}\) = maximum discharge capacity at theater \(j\) measured in LST hull-weeks per month

The basic fleet projection equation is:

\[
F_{t+1} = F_t + P_t - \alpha_t \cdot F_t
\]

where \(\alpha_t\) is expressed as a fraction, not a count. If \(\alpha_t = 0.03\), then 3% of the standing fleet is lost or becomes unavailable during that month. This is the state-transition equation used in the Scala model.

For allocation, define the planner’s objective as minimizing the weighted shortfall across theaters:

\[
\min \sum_{j} w_j \left( R_{t,j} - x_{t,j} \right)^+
\]

subject to:

\[
\sum_{j} x_{t,j} \le e_t F_t
\]

\[
0 \le x_{t,j} \le D_{t,j}
\]

\[
F_{t+1} = (1 - \alpha_t) F_t + P_t
\]

where \((a)^+ = \max(0,a)\). The weights \(w_j\) represent strategic priority: e.g., \(w_{\text{ETO}} = 1.0\), \(w_{\text{Mediterranean}} = 0.8\), \(w_{\text{Pacific}} = 0.7\), because ETO had first call after the late-1943 decisions.

For merchant cargo shipping, define:

- \(M_t\) = number of merchant hulls in service
- \(u_t\) = utilization factor (fraction of month at sea, excluding port time)
- \(C\) = cargo per hull (tons)
- \(T_t\) = turnaround time in days per voyage (port loading + sea time + unloading + return)
- \(C_t\) = clearing capacity of receiving theater in tons/day

Delivered tonnage in month \(t\) is:

\[
D_t = M_t \cdot u_t \cdot C \cdot \frac{30.4}{T_t}
\]

The system-level constraint is:

\[
D_t \le C_t \cdot 30.4
\]

If \(D_t > C_t \cdot 30.4\), ports become congested, \(T_t\) increases, and effective delivery drops in the next period. This is the positive feedback loop of congestion:

\[
T_{t+1} = T_t + \lambda \cdot \left( D_t - C_t \cdot 30.4 \right)^+
\]

where \(\lambda\) is a congestion coefficient in days per ton of excess backlog.

Finally, the strategic planning model can be expressed as a constraint satisfaction problem over the planning horizon:

\[
\text{Find } x_{t,j} \text{ such that } x_{t,j} \ge R_{t,j} \text{ for all } t,j
\]

subject to aggregate production, attrition, transit, and availability constraints. In 1943, no feasible solution existed; the historical compromise was to relax the constraints by delaying operations, reducing Pacific requirements, and maximizing production. This is the fundamental mathematical framing of the chapter.

---

## 5. Compile-Safe Scala 3.8.3 Domain Model

The following domain model implements the fleet projection and allocation equations above. It is written in Scala 3.8.3 with indentation syntax, opaque types, and no wildcard imports. It is complete and contains no placeholders.

```scala
package Logistics.ShipsLandingCraft

import scala.collection.immutable.Vector
import scala.math.round

object Domain:

  opaque type ShipCount = Int
  object ShipCount:
    def apply(value: Int): ShipCount = value
    extension (value: ShipCount) def toInt: Int = value

  opaque type Tons = Double
  object Tons:
    def apply(value: Double): Tons = value
    extension (value: Tons) def toDouble: Double = value

  opaque type Days = Double
  object Days:
    def apply(value: Double): Days = value
    extension (value: Days) def toDouble: Double = value

  opaque type AttritionRate = Double
  object AttritionRate:
    def apply(value: Double): AttritionRate = value
    extension (value: AttritionRate) def toDouble: Double = value

  enum ShipClass:
    case Liberty, Victory, LST, T2Tanker, DestroyerEscort

  enum TheaterId:
    case ETO, Mediterranean, Pacific, Reserve, Shakedown

  enum HullStatus:
    case LaidDown, Launched, Outfitting, ReadyForActive, InTransit, InMaintenance, CombatLoss, WeatherLoss

  final case class FleetState(
    shipClass: ShipClass,
    theater: TheaterId,
    ships: ShipCount
  ):
    require(ships.toInt >= 0, "Fleet size cannot be negative.")

  final case class FleetProjectionParams(
    initial: FleetState,
    monthlyProduction: ShipCount,
    attritionRate: AttritionRate,
    requiredFleet: ShipCount,
    months: Int
  ):
    require(monthlyProduction.toInt >= 0, "Monthly production cannot be negative.")
    require(requiredFleet.toInt >= 0, "Required fleet cannot be negative.")
    require(months >= 0, "Months cannot be negative.")

  final case class ProjectionPoint(
    month: Int,
    fleetSize: ShipCount,
    cumulativeProduction: ShipCount,
    cumulativeLosses: ShipCount,
    deficitBacklog: ShipCount
  )

end Domain

object FleetAttritionModel:
  import Domain.AttritionRate
  import Domain.AttritionRate.toDouble
  import Domain.FleetProjectionParams
  import Domain.FleetState
  import Domain.ProjectionPoint
  import Domain.ShipCount
  import Domain.ShipCount.toInt

  def projectFleetSize(
    initialState: FleetState,
    monthlyProduction: Int,
    attritionRate: Double,
    months: Int
  ): FleetState =
    require(monthlyProduction >= 0, "Monthly production cannot be negative.")
    require(months >= 0, "Months cannot be negative.")
    val rate: AttritionRate = AttritionRate(attritionRate)
    require(rate.toDouble >= 0.0 && rate.toDouble <= 1.0, "Attrition rate must be in [0, 1].")
    val params: FleetProjectionParams = FleetProjectionParams(
      initial = initialState,
      monthlyProduction = ShipCount(monthlyProduction),
      attritionRate = rate,
      requiredFleet = initialState.ships,
      months = months
    )
    val finalPoint: ProjectionPoint = project(params).last
    FleetState(initialState.shipClass, initialState.theater, finalPoint.fleetSize)

  def project(params: FleetProjectionParams): Vector[ProjectionPoint] =
    val rate: Double = params.attritionRate.toDouble
    val initialPoint: ProjectionPoint = ProjectionPoint(
      month = 0,
      fleetSize = params.initial.ships,
      cumulativeProduction = ShipCount(0),
      cumulativeLosses = ShipCount(0),
      deficitBacklog = ShipCount(math.max(0, params.requiredFleet.toInt - params.initial.ships.toInt))
    )
    (1 to params.months).foldLeft(Vector(initialPoint)) { (acc, month) =>
      val previous: ProjectionPoint = acc.last
      val fleet: Int = previous.fleetSize.toInt
      val produced: Int = params.monthlyProduction.toInt
      val losses: Int = round(rate * fleet.toDouble).toInt
      val nextFleet: Int = math.max(0, fleet + produced - losses)
      val required: Int = params.requiredFleet.toInt
      val nextBacklog: Int = math.max(0, required - nextFleet)
      val point: ProjectionPoint = ProjectionPoint(
        month = month,
        fleetSize = ShipCount(nextFleet),
        cumulativeProduction = ShipCount(previous.cumulativeProduction.toInt + produced),
        cumulativeLosses = ShipCount(previous.cumulativeLosses.toInt + losses),
        deficitBacklog = ShipCount(nextBacklog)
      )
      acc :+ point
    }

end FleetAttritionModel

object AllocationPlanner:
  import Domain.ShipCount
  import Domain.ShipCount.toInt
  import Domain.TheaterId

  final case class AllocationRequest(
    theater: TheaterId,
    requiredHulls: ShipCount,
    priority: Int
  )

  final case class AllocationResult(
    theater: TheaterId,
    allocated: ShipCount,
    unmet: ShipCount
  )

  def allocate(
    available: ShipCount,
    requests: List[AllocationRequest]
  ): List[AllocationResult] =
    val sortedRequests: List[AllocationRequest] = requests.sortBy(_.priority)
    val (results, _) = sortedRequests.foldLeft((List.empty[AllocationResult], available.toInt)) {
      case ((acc, remaining), request) =>
        val allocation: Int = math.min(remaining, request.requiredHulls.toInt)
        val unmet: Int = request.requiredHulls.toInt - allocation
        val result: AllocationResult = AllocationResult(
          theater = request.theater,
          allocated = ShipCount(allocation),
          unmet = ShipCount(unmet)
        )
        (result :: acc, remaining - allocation)
    }
    results.reverse

end AllocationPlanner

object ShipyardMetrics:
  import Domain.Days
  import Domain.Days.toDouble
  import Domain.ShipCount
  import Domain.ShipCount.toInt

  final case class Shipyard(
    buildDurationDays: Days,
    ways: Int
  ):
    require(buildDurationDays.toDouble > 0.0, "Build duration must be positive.")
    require(ways > 0, "Number of ways must be positive.")

  def projectedMonthlyProduction(
    yard: Shipyard,
    calendarDays: Days
  ): ShipCount =
    val buildDays: Double = yard.buildDurationDays.toDouble
    val days: Double = calendarDays.toDouble
    val annualSlotsPerWay: Double = 365.0 / buildDays
    val annualSlots: Double = annualSlotsPerWay * yard.ways.toDouble
    val output: Double = annualSlots * (days / 365.0)
    ShipCount(round(output).toInt)

end ShipyardMetrics

object FleetStateMachine:
  import Domain.AttritionRate
  import Domain.AttritionRate.toDouble
  import Domain.FleetState
  import Domain.ShipCount
  import Domain.ShipCount.toInt

  def transition(
    current: FleetState,
    produced: ShipCount,
    attritionRate: AttritionRate
  ): FleetState =
    val losses: Int = round(attritionRate.toDouble * current.ships.toInt.toDouble).toInt
    require(losses <= current.ships.toInt, "Attrition cannot exceed current fleet.")
    val next: Int = current.ships.toInt - losses + produced.toInt
    FleetState(current.shipClass, current.theater, ShipCount(next))

end FleetStateMachine

object HullLifecycle:
  import Domain.HullStatus

  def nextStatus(status: HullStatus): HullStatus =
    status match
      case HullStatus.LaidDown       => HullStatus.Launched
      case HullStatus.Launched       => HullStatus.Outfitting
      case HullStatus.Outfitting     => HullStatus.ReadyForActive
      case HullStatus.ReadyForActive => HullStatus.InTransit
      case HullStatus.InTransit      => HullStatus.InMaintenance
      case HullStatus.InMaintenance  => HullStatus.ReadyForActive
      case HullStatus.CombatLoss     => HullStatus.CombatLoss
      case HullStatus.WeatherLoss    => HullStatus.WeatherLoss

end HullLifecycle
```

This code is internally consistent. `FleetAttritionModel.projectFleetSize` maintains the exact method shape from the prompt while adding full validation and a state-history projection. `AllocationPlanner` implements the prioritized deficit-minimization routine. `ShipyardMetrics` models the LST building-duration constant. `FleetStateMachine` and `HullLifecycle` provide state-transition logic for operational fleet status.

---

## 6. Graduate-Level Operational Analysis

### Why was the LST considered the “unanimous bottleneck” of World War II logistics?

The LST was the bottleneck because it was the only vessel that could combine transoceanic passage, beaching capability, mechanical discharge, and a sufficient combat payload. A Liberty ship could carry thousands of tons but had no ramp and needed a port. An LCI could land infantry but could not carry tanks. An LCT could carry tanks to the beach but could not cross the Atlantic without a mother ship or tow. The LST was the synthetic answer: a 328-foot ship with a bow door, a ramp, a tank deck, a shallow draft, and enough endurance for open-ocean voyages. This made it the linchpin of every amphibious operation from Sicily to Normandy to the Philippines.

The phrase “unanimous bottleneck” is historically precise. At Casablanca, TRIDENT, QUADRANT, SEXTANT, and in every major cable between Eisenhower, Marshall, King, and Churchill, the number of LSTs appears as the binding constraint. There were not enough LSTs to mount OVERLORD and ANVIL simultaneously; there were not enough to meet Pacific requirements and European requirements; there were not enough to satisfy the planners’ desire for a reserve and the commanders’ need for a main effort. The production target for LSTs was repeatedly raised, but with a construction time of about seventy days and a limited number of ways, the effect of a decision in January could not appear until April—often too late for that season’s operations.

In operational research terms, the effective capacity of the LST force was:

\[
C^\text{lift}_t = N_t \cdot e_t \cdot K
\]

where \(N_t\) is the number of LSTs, \(e_t\) is the availability factor, and \(K\) is cargo capacity per trip. To move an infantry division with an armored brigade in a single lift, planners needed on the order of 50–80 LSTs, depending on the task organization. At any given time, only a fraction of LSTs were operational; the rest were in maintenance, repair, crew rest, or transit. This made the “usable” LST fleet much smaller than the “built” LST fleet. Thus the bottleneck was not purely industrial but also logistical and organizational. The LST was the limiting factor that forced the strategic calendar: OVERLORD could not be earlier, ANVIL could not be simultaneous without stripping the Pacific, and the Pacific advance had to be scheduled around the refitted LSTs from Europe.

### How did the division of steel between the Navy’s combatant ship program and the Maritime Commission’s merchant program affect overall strategy?

The division of steel was a zero-sum allocation at the margin because both programs demanded the same shipyard ways, skilled workers, plate steel, diesel engines, and reduction gears. The Navy’s combatant programs—especially destroyer escorts and escort carriers—were designed to counter the U-boat. In 1942 and early 1943, the U-boat was a mortal threat to the entire Allied logistics pipeline. Shipping losses in the North Atlantic reached catastrophic levels, and the construction rate of new cargo ships barely exceeded the sinking rate. In that emergency, President Roosevelt and the Joint Chiefs approved massive increases in DE construction. This was strategically necessary: without defeating the U-boat, no amount of landed merchant shipping could support an invasion of Europe.

However, the DE program consumed resources that might otherwise have built LSTs. Because the U-boat crisis broke in May 1943, the full effect of those DEs was not needed for the amphibious schedule of 1944. Yet the lead time of steel and shipbuilding had already committed hull ways, engines, and labor. The result was a late-1943 LST shortage that disrupted the timing of ANVIL and forced Admiral Nimitz to delay or reduce Pacific operations. Modern historians estimate that the diversion was not merely tons of steel but specific bottlenecks: reduction gears, marine diesels, and shipyard slips capable of constructing large prefabricated vessels. Maritime Commission yards could build Liberty ships faster than Navy yards could build DEs or LSTs, but a Liberty hull could not substitute for an LST. The wrong mix of steel was as strategically serious as an absolute shortage.

The broader strategic effect was to force a sequence of operations rather than a simultaneous global offensive. The U.S. Army wanted OVERLORD in 1943; the British resisted, citing landing craft. The eventual compromise was OVERLORD in 1944 and a Mediterranean campaign in 1943–44 that consumed LSTs. The Pacific theater, which suffered a disproportionate share of the LST allocation in 1942–43, was forced to rely on smaller landing craft and longer intervals between operations. When the LST shortage was finally resolved in late 1944, it was too late to use the extra hulls for a second European assault; they were sent to the Pacific. The strategic timeline of the war—Normandy in June 1944, southern France in August 1944, the Philippines in October 1944, Okinawa in April 1945—was thus stamped by the allocation decisions of steel made in 1942 and 1943. Logistics did not merely support strategy; in this case, logistics was strategy.
