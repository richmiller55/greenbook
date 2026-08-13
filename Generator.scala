package Logistics.Generator

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets

case class Chapter(
  id: Int,
  title: String,
  filename: String,
  context: String,
  fillins: String,
  mermaid: String,
  mathExplanation: String,
  mathFormula: String,
  scalaCode: String,
  discussionQuestions: String
)

object GeneratePrompts:
  val chapters: List[Chapter] = List(
    Chapter(
      id = 1,
      title = "Logistics and Strategy, Spring 1943",
      filename = "01-Logistics-and-Strategy-Spring-1943.md",
      context = """In the spring of 1943, following the Casablanca Conference (ANFA), Allied strategic planners faced the monumentally complex task of translating global strategic decisions into concrete logistical realities. The main tension lay between the BOLERO build-up in the United Kingdom for a cross-channel invasion, the continuation of operations in the Mediterranean (planning for HUSKY), and the shipping demands of the Pacific and Lend-Lease commitments.""",
      fillins = """- **Casablanca Conference Target Dates:**
  - The agreed target date for the cross-channel invasion (envisioned for 1944) was originally codenamed: `[___________]`
  - The target BOLERO troop shipment rate in early 1943 was planned at `[___________]` troops/month, though actual shipments fell to `[___________]` in March due to shipping shortages.
- **Merchant Shipping Pool:**
  - In Spring 1943, the global pool of Allied merchant shipping stood at approximately `[___________]` deadweight tons (dwt).
  - The estimated net cargo capacity loss due to the German U-boat campaign in the Atlantic during March 1943 was `[___________]` tons.""",
      mermaid = """```mermaid
graph TD
    US_Factories[US Industrial Base] --> POE[Ports of Embarkation]
    POE --> Convoy[Atlantic Convoy System]
    Convoy --> UK_Ports[UK Ports: Liverpool & Bristol]
    Convoy --> Med_Ports[Med Ports: Oran & Algiers]
    
    subgraph BOLERO Bottlenecks
        UK_Ports --> Discharge[Port Discharge Rate: ___ tons/day]
        Discharge --> Depots[Depots: G-25, G-35]
    end
```""",
      mathExplanation = """Logistical throughput is constrained by the turnaround time ($T$) of cargo vessels. We model the turnaround time in days for a single convoy cycle as a function of distance, speed, port delays, and convoy assembly time.""",
      mathFormula = """T = \frac{2D}{24 \cdot V} + L_{port} + U_{port} + D_{convoy}""",
      scalaCode = """package Logistics.Spring1943

import scala.annotation.targetName

opaque type NauticalMiles = Double
object NauticalMiles:
  def apply(value: Double): NauticalMiles = value
  extension (nm: NauticalMiles) def toDouble: Double = nm

opaque type Knots = Double
object Knots:
  def apply(value: Double): Knots = value
  extension (k: Knots) def toDouble: Double = k

opaque type Days = Double
object Days:
  def apply(value: Double): Days = value
  extension (d: Days)
    def toDouble: Double = d
    @targetName("addDays")
    def +(other: Days): Days = Days(d + other.toDouble)

case class PortParameters(
  loadingTime: Days,
  unloadingTime: Days,
  convoyDelay: Days
)

object ConvoyModel:
  def calculateTurnaround(
    distance: NauticalMiles,
    speed: Knots,
    ports: PortParameters
  ): Days =
    val transitDays = Days((2.0 * distance.toDouble) / (24.0 * speed.toDouble))
    transitDays + ports.loadingTime + ports.unloadingTime + ports.convoyDelay""",
      discussionQuestions = """1. Why did the high troop-to-service ratio in Spring 1943 limit the offensive capability of the Allied armies in the Mediterranean?
2. Detail how the "ship-against-division" calculation influenced General George C. Marshall’s strategy regarding the timing of Operation OVERLORD."""
    ),
    Chapter(
      id = 2,
      title = "Husky and Bolero",
      filename = "02-Husky-and-Bolero.md",
      context = """This chapter focuses on the severe strategic conflict between two massive operations in mid-1943: Operation HUSKY (the amphibious invasion of Sicily) and Operation BOLERO (the long-term logistical build-up in the UK). The core logistical bottleneck was the allocation of Landing Craft (specifically LSTs, LCIs, and LCTs) and combat-loaded troop transports.""",
      fillins = """- **Landing Craft Allocations:**
  - The total number of LSTs (Landing Ship, Tank) required for the initial assault phase of Operation HUSKY was `[___________]`.
  - The Joint Chiefs of Staff (JCS) agreed to withdraw `[___________]` LSTs from the BOLERO pool to support HUSKY.
- **The BOLERO Slowdown:**
  - In May 1943, the troop strength in the United Kingdom was supposed to reach `[___________]` but actually stood at `[___________]` due to Mediterranean diversions.""",
      mermaid = """```mermaid
graph TD
    Pool[Global LST Pool] --> JCS{JCS / CCS Allocation}
    JCS -- "MTO" --> HUSKY[Operation HUSKY]
    JCS -- "ETO" --> BOLERO[Operation BOLERO]
    HUSKY --> H_LST[LSTs allocated: ___]
    BOLERO --> B_LST[LSTs remaining: ___]
```""",
      mathExplanation = """The resource conflict between HUSKY and BOLERO can be modeled as a resource allocation problem under a hard ceiling where allocations must satisfy minimum operational thresholds for both theaters.""",
      mathFormula = """X_{H} + X_{B} \le C_{total}, \quad X_{H} \ge X_{H}^{min}, \quad X_{B} \ge X_{B}^{min}""",
      scalaCode = """package Logistics.HuskyBolero

import scala.collection.immutable.List

case class CraftPool(totalLST: Int)

case class Allocation(huskyLST: Int, boleroLST: Int):
  def isValid(pool: CraftPool): Boolean =
    huskyLST + boleroLST <= pool.totalLST

object ResourceAllocator:
  def findFeasibleAllocations(
    pool: CraftPool,
    minHusky: Int,
    minBolero: Int
  ): List[Allocation] =
    for
      h <- (minHusky to pool.totalLST).toList
      b = pool.totalLST - h
      if b >= minBolero
    yield Allocation(h, b)""",
      discussionQuestions = """1. How did the British and American viewpoints differ at the Washington Conference regarding the trade-offs between HUSKY and BOLERO?
2. What role did the "Anvil" (later "Dragoon") debate play in the landing craft allocation disputes of early 1943?"""
    ),
    Chapter(
      id = 3,
      title = "The TRIDENT Conference",
      filename = "03-The-TRIDENT-Conference.md",
      context = """The TRIDENT Conference (Washington, May 1943) established the global strategy for the remainder of 1943 and early 1944. It forced a critical evaluation of resource distribution between the European Theater of Operations (ETO), the Mediterranean Theater of Operations (MTO), and the Pacific theaters, balancing political pressures and material realities.""",
      fillins = """- **Strategic Resource Divisions:**
  - TRIDENT set the target date for the cross-channel invasion (OVERLORD) as `[___________]`.
  - The conference authorized an increase in Pacific air strength by adding `[___________]` air squadrons.
  - Planners calculated that supporting the Pacific operations required a shipping allocation of `[___________]` tons per month.""",
      mermaid = """```mermaid
graph TD
    TRIDENT[TRIDENT Conference] --> ETO_Cap[ETO Target: 29 Divisions]
    TRIDENT --> MTO_Cap[MTO Target: Sicily + Italy]
    TRIDENT --> Pacific_Cap[Pacific Target: Cartwheel & Central Pac]
```""",
      mathExplanation = """Multi-theater resource allocation balances priorities by assigning strategic weights to theaters and computing the optimal supply distribution factor based on utility and distance costs.""",
      mathFormula = """S_i = \frac{W_i \cdot C_{total}}{\sum_{j} W_j} \cdot (1 - \theta_i)""",
      scalaCode = """package Logistics.Trident

import scala.collection.immutable.Map

case class Theater(name: String, weight: Double, distancePenalty: Double)

object TridentPrioritization:
  def allocateSupplies(
    theaters: List[Theater],
    totalSupplies: Double
  ): Map[String, Double] =
    val totalWeight = theaters.map(t => t.weight * (1.0 - t.distancePenalty)).sum
    theaters.map { t =>
      val adjustedWeight = t.weight * (1.0 - t.distancePenalty)
      t.name -> (adjustedWeight / totalWeight) * totalSupplies
    }.toMap""",
      discussionQuestions = """1. How did TRIDENT resolve the fundamental disagreement between Roosevelt and Churchill on the expansion of Mediterranean operations?
2. To what extent did Pacific shipping requirements limit the ETO troop build-up scheduled at TRIDENT?"""
    ),
    Chapter(
      id = 4,
      title = "Logistical Organization",
      filename = "04-Logistical-Organization.md",
      context = """This chapter details the restructuring of the Army Service Forces (ASF) under Lt. Gen. Brehon B. Somervell and the creation of Theater of Operations structures (ETOUSA, SOS in Europe). It highlights the massive organizational friction of managing wholesale logistics across globally dispersed commands.""",
      fillins = """- **Organizational Milestones:**
  - The Services of Supply (SOS) in the European Theater was redesignated the Communications Zone (ComZ) on `[___________]`.
  - Under Somervell's reorganization, the Technical Services of the Army were consolidated into `[___________]` major corps (including Quartermaster, Ordnance, and Engineers).""",
      mermaid = """```mermaid
graph TD
    WD[War Department] --> ASF[Army Service Forces - Somervell]
    ASF --> POE[Ports of Embarkation]
    WD --> ETOUSA[ETOUSA - Theater Commander]
    ETOUSA --> SOS[Services of Supply / ComZ]
    SOS --> Section_Commands[Base, Intermediate, and Advance Sections]
```""",
      mathExplanation = """We model the organizational communication latency ($L$) as a function of hierarchical depth ($D$) and span of control ($S$) where nodes route logistical requests downstream.""",
      mathFormula = """L = D \cdot \log_e(S) + T_{processing}""",
      scalaCode = """package Logistics.Organization

import scala.math.log

case class Hierarchy(depth: Int, spanOfControl: Int)

object OrganizationModel:
  def calculateCommunicationLatency(
    h: Hierarchy,
    processingDelay: Double
  ): Double =
    h.depth * log(h.spanOfControl.toDouble) + processingDelay""",
      discussionQuestions = """1. Discuss the command conflicts between General Dwight D. Eisenhower (as Theater Commander) and General Somervell (as ASF Commander) regarding control over logistics in North Africa and England.
2. How did the division of the theater into Base, Intermediate, and Advance Sections prevent double-handling of materials?"""
    ),
    Chapter(
      id = 5,
      title = "Army Requirements, 1943-44",
      filename = "05-Army-Requirements-1943-44.md",
      context = """Determining the material requirements for an army of millions of men required predicting future combat conditions, equipment replacement factors, and maintenance pipelines. This chapter covers the compilation of the "Victory Program" and the formulation of the Troop Basis and Supply Scales.""",
      fillins = """- **Requirement Planning:**
  - The standard daily maintenance requirement for a US soldier in the field in 1943 was calculated at `[___________]` pounds of supply per day.
  - The "Troop Basis" for 1943 authorized a maximum mobilization strength of `[___________]` officers and men.
  - The replacement factor (loss rate) for medium tanks in combat was estimated in requirements planning to be `[___________]`% per month.""",
      mermaid = """```mermaid
graph TD
    TroopBasis[Troop Basis: Divisions & Units] --> SupplyScales[Supply Scales: Pounds/Man/Day]
    SupplyScales --> Gross_Requirements[Gross Requirements: Tons]
    Gross_Requirements --> Production_Alloc[War Production Board Allocation]
```""",
      mathExplanation = """Requirement forecasting models future monthly tonnage requirements ($R_{month}$) using the troop strength ($P$), the daily supply factor ($F_{day}$), and an equipment loss/replacement buffer ($B$).""",
      mathFormula = """R_{month} = \left( P \cdot F_{day} \cdot 30 \right) \cdot (1 + B)""",
      scalaCode = """package Logistics.Requirements

opaque type Troops = Int
object Troops:
  def apply(value: Int): Troops = value
  extension (t: Troops) def toInt: Int = t

opaque type PoundsPerDay = Double
object PoundsPerDay:
  def apply(value: Double): PoundsPerDay = value
  extension (p: PoundsPerDay) def toDouble: Double = p

object RequirementForecaster:
  def forecastMonthlyTons(
    troops: Troops,
    factor: PoundsPerDay,
    buffer: Double
  ): Double =
    val lbsPerMonth = troops.toInt * factor.toDouble * 30.0
    val tonsPerMonth = lbsPerMonth / 2000.0
    tonsPerMonth * (1.0 + buffer)""",
      discussionQuestions = """1. Explain how the discrepancy between "production capability" (WPB) and "military requirements" (ASF) was resolved in the mid-war period.
2. What are the dangers of overestimating replacement factors, and how did it lead to the "overstocking" crisis of late 1943?"""
    ),
    Chapter(
      id = 6,
      title = "The Mechanics of Wholesale Distribution",
      filename = "06-The-Mechanics-of-Wholesale-Distribution.md",
      context = """This chapter explores the physical mechanics of logistics: moving supplies from US factories to depots, port clearances, and cargo loading. It introduces the vital concepts of balanced cargo loading (combining heavy and volumetric cargo) to maximize the utilization of ship capacity.""",
      fillins = """- **Distribution Capabilities:**
  - The "overland rail movement" from interior depots to Atlantic ports reached a peak of `[___________]` carloads per day in late 1943.
  - Balanced loading required maintaining a ship's density of approximately `[___________]` cubic feet per measurement ton.""",
      mermaid = """```mermaid
graph TD
    Factory[Factory Output] --> Depot[Inland Depots]
    Depot --> Rail[Overland Rail Network]
    Rail --> Port_Depot[Port Holding Yards]
    Port_Depot --> Ships[Cargo Vessels]
```""",
      mathExplanation = """To prevent a vessel from "filling its volume" before "reaching its weight limit" (or vice versa), cargo must be balanced. The optimal ratio of heavy cargo ($M_{heavy}$) to light/volumetric cargo ($M_{light}$) is derived based on vessel weight limit ($W_{max}$) and volumetric capacity ($V_{max}$).""",
      mathFormula = """S_f \cdot M_{heavy} + S_l \cdot M_{light} \le V_{max} \quad \text{and} \quad M_{heavy} + M_{light} \le W_{max}""",
      scalaCode = """package Logistics.Distribution

case class VesselConstraints(weightCapacityTons: Double, volumeCapacityCuFt: Double)
case class CargoProperties(heavyStowageFactor: Double, lightStowageFactor: Double)

object DistributionOptimizer:
  def calculateMaxCargo(
    v: VesselConstraints,
    c: CargoProperties
  ): (Double, Double) =
    // Solving the linear system:
    // H * Sf + L * Sl = V
    // H + L = W
    // H = (V - W * Sl) / (Sf - Sl)
    val heavy = (v.volumeCapacityCuFt - v.weightCapacityTons * c.lightStowageFactor) / 
                (c.heavyStowageFactor - c.lightStowageFactor)
    val light = v.weightCapacityTons - heavy
    (heavy, light)""",
      discussionQuestions = """1. What was the purpose of the "Holding and Reconsignment Points" (H&RPs) in the US railroad transport system, and how did they prevent port congestion?
2. Detail the difference between "Measurement Tons" (40 cubic feet) and "Long Tons" (2240 lbs), and why this distinction was vital for ship planning."""
    ),
    Chapter(
      id = 7,
      title = "Outline OVERLORD and the Invasion of Italy",
      filename = "07-Outline-OVERLORD-and-the-Invasion-of-Italy.md",
      context = """While COSSAC (Chief of Staff to the Supreme Allied Commander) drafted the outline plan for Operation OVERLORD in London, the Allied forces in the Mediterranean launched invasions of the Italian mainland (Salerno/Operation AVALANCHE). This double commitment tested the limits of port clearance and shipping capacities.""",
      fillins = """- **Assault Parameters:**
  - The COSSAC outline plan for OVERLORD, presented in mid-1943, envisioned an initial assault force of `[___________]` divisions.
  - The Salerno landings (AVALANCHE) on D-Day (`[___________]`) suffered from a major shortage of amphibious shipping, with only `[___________]` combat-loaded ships available.""",
      mermaid = """```mermaid
graph TD
    COSSAC[COSSAC Planning Staff] --> OVERLORD_Plan[Outline OVERLORD: 3 Assault Divisions]
    MTO_Command[MTO Command] --> AVALANCHE[Salerno Landings]
    AVALANCHE --> Naples_Port[Capture of Naples Port]
```""",
      mathExplanation = """Port throughput ($P_{throughput}$) is constrained by berth occupancy rates, discharge rates per hook-hour, and truck evacuation capacity.""",
      mathFormula = """P_{throughput} = B \cdot R_{discharge} \cdot 24 \cdot E_{efficiency}""",
      scalaCode = """package Logistics.OverlordItaly

case class PortSpecs(berths: Int, dischargeRateTonsPerHour: Double, efficiency: Double)

object PortThroughputModel:
  def dailyCapacity(specs: PortSpecs): Double =
    specs.berths * specs.dischargeRateTonsPerHour * 24.0 * specs.efficiency""",
      discussionQuestions = """1. Why did the COSSAC staff believe that the three-division assault limit for OVERLORD was logistically mandatory, and who later insisted on expanding it?
2. Analyze how the destruction of the Port of Naples by retreating German forces impacted the logistical support of the Fifth Army in Italy."""
    ),
    Chapter(
      id = 8,
      title = "First Quebec Conference (QUADRANT)",
      filename = "08-First-Quebec-Conference-QUADRANT.md",
      context = """At the QUADRANT Conference (August 1943), the Combined Chiefs of Staff formally approved the COSSAC plan for OVERLORD and established a concrete pipeline of resources. It also marked the creation of the Southeast Asia Command (SEAC) to reorganize the chaotic CBI theater.""",
      fillins = """- **QUADRANT Decisions:**
  - The target date for OVERLORD was finalized as `[___________]` (month/year).
  - The Allied leaders agreed to prioritize the construction of `[___________]` artificial harbors (Mulberry harbors) to bypass French ports in the early stages of the invasion.""",
      mermaid = """```mermaid
graph TD
    QUADRANT[First Quebec Conference] --> Overlord_App[Formally Approve OVERLORD]
    QUADRANT --> Mulberry_Auth[Authorize Mulberry Harbors]
    QUADRANT --> SEAC_Est[Establish SEAC under Mountbatten]
```""",
      mathExplanation = """Logistical pipeline lead time ($L_{total}$) accounts for manufacturing, transit, depot processing, and final delivery, creating a temporal delay before resource changes take effect in theater.""",
      mathFormula = """L_{total} = T_{mfg} + T_{transit} + T_{processing}""",
      scalaCode = """package Logistics.Quadrant

opaque type Days = Int
object Days:
  def apply(value: Int): Days = value
  extension (d: Days) def toInt: Int = d

case class PipelineStages(mfg: Days, transit: Days, processing: Days)

object PipelineLeadTime:
  def totalLeadTime(stages: PipelineStages): Days =
    Days(stages.mfg.toInt + stages.transit.toInt + stages.processing.toInt)""",
      discussionQuestions = """1. How did the creation of SEAC aim to resolve the command conflicts between the British, the Americans (Stilwell), and the Chinese (Chiang Kai-shek)?
2. What logistical challenges prompted the decision to build artificial "Mulberry" harbors, and what resources were allocated to their construction?"""
    ),
    Chapter(
      id = 9,
      title = "Bog-Down in the Mediterranean",
      filename = "09-Bog-Down-in-the-Mediterranean.md",
      context = """The Italian campaign slowed to a crawl during the winter of 1943-44. Planners encountered extreme weather, mountainous terrain, and destroyed infrastructure, which severely degraded supply movements. The bold end-run amphibious landing at Anzio (Operation SHINGLE) was launched to break the deadlock but quickly became logistically isolated.""",
      fillins = """- **Campaign Challenges:**
  - The Anzio landings (Operation SHINGLE) were launched on `[___________]`.
  - Instead of breaking out, the Allied force was pinned down in a beachhead measuring only `[___________]` miles wide.
  - Sustaining the Anzio pocket required a daily supply delivery of `[___________]` tons, which had to be brought in via LSTs and trucks under artillery fire.""",
      mermaid = """```mermaid
graph TD
    WinterStalemate[Winter Line Stalemate] --> ShinglePlan[Anzio Landing - SHINGLE]
    ShinglePlan --> PinDown[Beachhead Isolation]
    PinDown --> SupplyLST[LST Shuttle from Naples: ___ tons/day]
```""",
      mathExplanation = """Road capacity in mountainous terrain under combat and weather conditions is limited. Truck throughput capacity ($C_{road}$) is modeled as a function of operational trucks ($N$), speed ($V$), and road degradation factor ($F_{degrad}$).""",
      mathFormula = """C_{road} = N \cdot \frac{V \cdot Payload}{Distance} \cdot F_{degrad}""",
      scalaCode = """package Logistics.BogDown

case class TruckConvoy(truckCount: Int, averagePayloadTons: Double, distanceMiles: Double)

object RoadThroughputModel:
  def calculateDailyTonnage(
    convoy: TruckConvoy,
    speedMph: Double,
    degradationFactor: Double
  ): Double =
    val tripsPerDay = (speedMph * 12.0) / convoy.distanceMiles // 12-hour driving day
    val potentialTons = convoy.truckCount * convoy.averagePayloadTons * tripsPerDay
    potentialTons * degradationFactor""",
      discussionQuestions = """1. Why did Operation SHINGLE fail to achieve its strategic objectives, and how did its logistical requirements drain resources from the preparations for OVERLORD?
2. Describe the "Naples-Anzio LST Shuttle" and how it represented an innovative use of amphibious shipping in a sustained support role."""
    ),
    Chapter(
      id = 10,
      title = "Ships, Landing Craft, and Strategy",
      filename = "10-Ships-Landing-Craft-and-Strategy.md",
      context = """This chapter serves as a deep dive into the supreme constraint of the European war: shipping and landing craft. It examines the competition for steel, shipyard capacities, and the impact of landing craft production on the global strategic timeline.""",
      fillins = """- **Shipping Pool Dynamics:**
  - The production of Liberty ships peaked in 1943, with US shipyards completing `[___________]` vessels in that year alone.
  - The global deficit in LST production in late 1943 stood at `[___________]` craft below the requirements of ETO planners.""",
      mermaid = """```mermaid
graph TD
    Steel[Steel Allocation] --> Shipyards[US Shipyards]
    Shipyards --> Merchant[Merchant Ships: Liberty/Victory]
    Shipyards --> Amphibious[Landing Craft: LST, LCI, LCT]
    Amphibious --> Shortage[Strategic Bottleneck]
```""",
      mathExplanation = """Fleet sizing must account for both production rate ($P_t$) and combat/operational attrition rate ($A_t$) to calculate net fleet size over time.""",
      mathFormula = """F_{t+1} = F_t + P_t - A_t \cdot F_t""",
      scalaCode = """package Logistics.ShipsLandingCraft

case class FleetState(ships: Int)

object FleetAttritionModel:
  def projectFleetSize(
    initialState: FleetState,
    monthlyProduction: Int,
    attritionRate: Double,
    months: Int
  ): FleetState =
    val finalShips = (1 to months).foldLeft(initialState.ships.toDouble) { (current, _) =>
      current + monthlyProduction - (attritionRate * current)
    }
    FleetState(finalShips.toInt)""",
      discussionQuestions = """1. Explain why the LST was considered the "unanimous bottleneck" of World War II logistics.
2. How did the division of steel between the Navy's combatant ship program and the Maritime Commission's merchant program affect overall strategy?"""
    ),
    Chapter(
      id = 11,
      title = "The Cairo-Tehran Conferences (SEXTANT/EUREKA)",
      filename = "11-The-Cairo-Tehran-Conferences.md",
      context = """The SEXTANT (Cairo) and EUREKA (Tehran) conferences in late 1943 brought Roosevelt, Churchill, and Stalin together. Stalin’s firm demand for a primary cross-channel operation (OVERLORD) in mid-1944 forced the cancellation of planned Mediterranean amphibious operations (such as Operation BUCCANEER in the Bay of Bengal).""",
      fillins = """- **Conference Outcomes:**
  - At Tehran, Stalin committed to launching a simultaneous Soviet offensive (Operation `[___________]`) to prevent Germany from shifting divisions westward.
  - The cancellation of Operation BUCCANEER released `[___________]` landing craft back to the European pool.""",
      mermaid = """```mermaid
graph TD
    SEXTANT[Cairo: SEXTANT] --> EUREKA[Tehran: EUREKA]
    EUREKA --> Soviet_Demands[Soviet Demand: OVERLORD Primary]
    EUREKA --> Canc_Med[Cancel Mediterranean/BBI Amphibious Operations]
    Canc_Med --> Release_LC[Release Landing Craft to OVERLORD]
```""",
      mathExplanation = """We model the coalition resource division as a multi-objective utility matrix where strategic alignment maximizes global Allied offensive value.""",
      mathFormula = """U_{allied} = \sum_{i} A_i \cdot V_i""",
      scalaCode = """package Logistics.CairoTehran

case class TheaterObjective(name: String, alignmentScore: Double, resourceRequired: Double)

object CoalitionResourceSplit:
  def evaluateAllocations(
    objectives: List[TheaterObjective],
    availableResources: Double
  ): List[TheaterObjective] =
    objectives.filter(_.resourceRequired <= availableResources)""",
      discussionQuestions = """1. Why did Stalin’s presence at Tehran fundamentally alter the balance of power between the US and British strategic concepts?
2. Explain the logistical and strategic implications of canceling Operation BUCCANEER."""
    ),
    Chapter(
      id = 12,
      title = "Inventory and Aftermath",
      filename = "12-Inventory-and-Aftermath.md",
      context = """This chapter reviews the logistical balance sheet at the end of 1943. Planners assessed shipping losses, depot stocks in England, and port preparations to confirm whether the massive pipeline from the United States could support the scheduled 1944 offensives.""",
      fillins = """- **End of 1943 Balance Sheet:**
  - By December 1943, the total US Army cargo shipped to the United Kingdom for BOLERO reached `[___________]` long tons.
  - Despite major shipping efforts, there was a stock deficit in critical Category II equipment (e.g., trucks and trailers) of `[___________]`%.""",
      mermaid = """```mermaid
graph TD
    US_Supply[US Factory Outputs] --> Shipping[Ocean Shipping: 1943]
    Shipping --> UK_Depots[UK Storage & Assembly]
    UK_Depots --> Audit{Stock Audit: Late 1943}
    Audit -- Shortage --> Procurement[Emergency Procurement]
    Audit -- Surplus --> Redistribution[Redistribution]
```""",
      mathExplanation = """Stock balance is evaluated by comparing actual stock levels ($S_{actual}$) against authorized levels ($S_{auth}$). Excesses and deficits are computed to identify system-wide imbalances.""",
      mathFormula = """Imbalance_i = \frac{S_{actual} - S_{auth}}{S_{auth}}""",
      scalaCode = """package Logistics.InventoryAftermath

case class StockItem(name: String, actual: Double, authorized: Double)

object InventoryBalanceModel:
  def computeImbalances(items: List[StockItem]): List[(String, Double)] =
    items.map { item =>
      val ratio = (item.actual - item.authorized) / item.authorized
      item.name -> ratio
    }""",
      discussionQuestions = """1. What were the main causes of the "imbalance" in UK depots at the end of 1943?
2. How did the reduction in Atlantic shipping losses in late 1943 affect the logistical outlook for OVERLORD?"""
    ),
    Chapter(
      id = 13,
      title = "OVERLORD and ANVIL",
      filename = "13-OVERLORD-and-ANVIL.md",
      context = """The conflict between the cross-channel invasion (OVERLORD) and the landing in Southern France (ANVIL) dominated Allied planning in early 1944. Planners debated whether ANVIL was a necessary diversion to secure French ports (Marseille) or a dangerous division of scarce landing craft.""",
      fillins = """- **Invasion Planning:**
  - The expanded OVERLORD plan (formulated by Montgomery and Eisenhower) required increasing the assault force from 3 to `[___________]` divisions.
  - To secure enough landing craft for this expanded assault, ANVIL had to be postponed from its original simultaneous date to `[___________]`.""",
      mermaid = """```mermaid
graph TD
    JCS[Joint Chiefs] --> Overlord_Priority[OVERLORD: Normandy]
    JCS --> Anvil_Priority[ANVIL: Southern France]
    Overlord_Priority -- "Demands Landing Craft" --> LC_Squeeze[Landing Craft Squeeze]
    Anvil_Priority -- "Relinquishes LSTs" --> LC_Squeeze
```""",
      mathExplanation = """We model the operational dependency tree using the Critical Path Method (CPM). The early start ($ES$) and late start ($LS$) times for critical operations (like ANVIL) are computed based on resource constraints.""",
      mathFormula = """ES_j = \max_{i \in Pred(j)} \{ EF_i \}""",
      scalaCode = """package Logistics.OverlordAnvil

case class Task(name: String, durationDays: Int, predecessors: List[String])

object ProjectScheduler:
  def calculateSimpleSchedule(tasks: List[Task]): Map[String, Int] =
    // Assumes simple topological ordering for early-start calculation
    tasks.foldLeft(Map[String, Int]()) { (acc, task) =>
      val es = task.predecessors.map(p => acc.getOrElse(p, 0) + tasks.find(_.name == p).map(_.durationDays).getOrElse(0)).maxOption.getOrElse(0)
      acc + (task.name -> es)
    }""",
      discussionQuestions = """1. Why did General Eisenhower view the ANVIL operation as logistically essential for the long-term support of the Allied drive into Germany?
2. Analyze the strategic debate between the British (who favored exploiting the Italian campaign or the Balkans) and the Americans (who stood firm on ANVIL)."""
    ),
    Chapter(
      id = 14,
      title = "The OVERLORD-ANVIL Build-Up",
      filename = "14-The-OVERLORD-ANVIL-Build-Up.md",
      context = """In the months preceding D-Day, the United Kingdom became a packed logistical platform. This chapter describes the final, massive movement of troops and supplies to Southern England ports, the waterproofing of thousands of vehicles, and the organization of the pre-planned "push" supply system.""",
      fillins = """- **The Final Build-Up:**
  - By June 1944, the number of US troops in the UK reached approximately `[___________]` million.
  - Over `[___________]` separate types of vehicles had to be waterproofed for the amphibious landings.
  - The initial "push" supply system was scheduled to sustain the landing forces for the first `[___________]` days before transitioning to a "pull" requisition system.""",
      mermaid = """```mermaid
graph TD
    Inland_Depots[Inland UK Depots] --> Transit_Camps[Transit/Marshalling Camps]
    Transit_Camps --> Waterproofing[Waterproofing Stations]
    Waterproofing --> Embarkation[Embarkation Ports]
```""",
      mathExplanation = """Vehicle waterproofing required specialized kits, labor, and space. We model the throughput of waterproofing lines using a multi-station queue capacity.""",
      mathFormula = """T_{waterproof} = N_{lines} \cdot R_{rate} \cdot H_{hours}""",
      scalaCode = """package Logistics.BuildUp

case class WaterproofingStation(lines: Int, ratePerLinePerHour: Double)

object StoragePacking:
  def maxWaterproofCapacity(station: WaterproofingStation, dailyHours: Double): Int =
    (station.lines * station.ratePerLinePerHour * dailyHours).toInt""",
      discussionQuestions = """1. What is the difference between a "push" supply system and a "pull" supply system, and why was the former mandatory for the initial D-Day landings?
2. How did the "Marshalling Areas" in Southern England function to maintain tactical organization while handling massive logistical throughput?"""
    ),
    Chapter(
      id = 15,
      title = "The Aftermath of OVERLORD",
      filename = "15-The-Aftermath-of-OVERLORD.md",
      context = """Following the successful landings on June 6, 1944, the Allies faced the critical task of sustaining the breakout. Planners wrestled with the destruction of the Mulberry harbor at Omaha beach by a severe storm, the slow capture of Cherbourg, and the creation of the famous "Red Ball Express" truck convoy system to chase the rapid breakout.""",
      fillins = """- **Post-Invasion Logistics:**
  - The severe storm of June `[___________]` completely destroyed the American Mulberry harbor ("Mulberry A") at Omaha Beach.
  - The Red Ball Express was established on August 25, 1944, and operated a fleet of `[___________]` trucks at its peak.
  - The daily fuel requirement for a rapid pursuit division in August 1944 was approximately `[___________]` gallons of gasoline.""",
      mermaid = """```mermaid
graph TD
    Normandy_Beaches[Normandy Beaches / Cherbourg] -- "Red Ball Express" --> Front_Line[Third & First Army Depots]
    Red Ball Express --> OneWayLoop[One-Way Loop Highway]
    OneWayLoop --> VehicleMaintenance[Field Maintenance Depots]
```""",
      mathExplanation = """The Red Ball Express is a network flow problem. The maximum daily tonnage ($T_{max}$) delivered is bounded by the number of operational trucks, fuel consumption of the fleet, and road congestion limits.""",
      mathFormula = """T_{max} = \frac{N \cdot P_{payload}}{2 \cdot (D / V + T_{load})}""",
      scalaCode = """package Logistics.OverlordAftermath

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
    config.trucks * config.payloadTons * tripsPerDay""",
      discussionQuestions = """1. How did the loss of the Omaha Mulberry harbor alter the planned Allied supply schedule, and what alternative methods proved surprisingly successful?
2. Analyze the logistical cost of the rapid breakout (pursuit) across France, focusing on the point where the consumption of fuel by supply trucks exceeded the delivery to combat units."""
    ),
    Chapter(
      id = 16,
      title = "Pacific Strategy and Its Material Bases",
      filename = "16-Pacific-Strategy-and-Its-Material-Bases.md",
      context = """Logistics in the Pacific War was fundamentally different from the European Theater. Distances were vast, landbases were scarce, and joint Army-Navy cooperation was mandatory. This chapter analyzes the physical geography and shipping networks that formed the basis of Pacific strategy.""",
      fillins = """- **Pacific Logistical Dimensions:**
  - The shipping lane from San Francisco to Brisbane, Australia covered approximately `[___________]` nautical miles.
  - Sustaining a single soldier in the Pacific required shipping `[___________]` times the volume of supplies required for a soldier in Europe due to the lack of local infrastructure.""",
      mermaid = """```mermaid
graph TD
    US_WestCoast[US West Coast POEs] --> Pearl_Harbor[Pearl Harbor Hub]
    Pearl_Harbor --> SouthPac[South Pacific Bases: Fiji, Noumea]
    SouthPac --> SW_Pac[Southwest Pacific: Brisbane, Hollandia]
```""",
      mathExplanation = """The efficiency of supply delivery in the Pacific decayed exponentially with distance. We model the effective supply throughput ($S_{eff}$) delivered to an island base as a function of distance ($D$) and operational transport loss/turnaround delays.""",
      mathFormula = """S_{eff} = S_0 \cdot e^{-\lambda \cdot D}""",
      scalaCode = """package Logistics.PacificStrategy

import scala.math.exp

object PacificSupplyLossModel:
  def effectiveThroughput(
    initialTonnage: Double,
    distanceMiles: Double,
    decayRate: Double
  ): Double =
    initialTonnage * exp(-decayRate * distanceMiles)""",
      discussionQuestions = """1. Explain the logistical concept of "island hopping" and how it minimized the shipping tonnage required to advance the strategic front.
2. How did the geographic vastness of the Pacific impact the "turnaround time" of merchant shipping compared to the North Atlantic route?"""
    ),
    Chapter(
      id = 17,
      title = "Joint Logistics in Pacific Operations: The Continental System",
      filename = "17-Joint-Logistics-in-Pacific-Operations-The-Continental-System.md",
      context = """Managing the dual demands of the Army and Navy in the Pacific required setting up unified logistical boards. This chapter explores the "Continental System" developed on the US West Coast to coordinate procurement, storage, and port facilities for both services.""",
      fillins = """- **Joint Systems:**
  - The Joint Army-Navy Logistics Board (JANET) was established in `[___________]`.
  - The West Coast Ports of Embarkation (especially San Francisco) cleared over `[___________]` measurement tons of cargo per month for the Pacific in late 1944.""",
      mermaid = """```mermaid
graph TD
    Army_Proc[Army Procurement] --> JANET{Joint Logistics Board}
    Navy_Proc[Navy Procurement] --> JANET
    JANET --> WC_Ports[West Coast POEs]
```""",
      mathExplanation = """We model the port clearance queue as a shared resource system using a single-server queueing model (M/M/1) where arrival rate ($\lambda$) and service rate ($\mu$) determine the average port delay ($W$).""",
      mathFormula = """W = \frac{1}{\mu - \lambda}""",
      scalaCode = """package Logistics.ContinentalSystem

case class PortQueue(arrivalRatePerDay: Double, serviceRatePerDay: Double)

object QueueingModel:
  def averageDelayDays(queue: PortQueue): Double =
    if queue.serviceRatePerDay > queue.arrivalRatePerDay then
      1.0 / (queue.serviceRatePerDay - queue.arrivalRatePerDay)
    else
      Double.PositiveInfinity""",
      discussionQuestions = """1. What were the main sources of friction between the Army Service Forces and the Navy's Bureau of Supplies and Accounts during the establishment of the West Coast joint ports?
2. How did the "Continental System" prevent the duplication of storage depots in California?"""
    ),
    Chapter(
      id = 18,
      title = "Joint Logistics in the Pacific Theaters",
      filename = "18-Joint-Logistics-in-the-Pacific-Theaters.md",
      context = """This chapter moves into the actual theater of operations, analyzing how General Douglas MacArthur’s Southwest Pacific Area (SWPA) and Admiral Chester Nimitz’s Pacific Ocean Areas (POA) managed supply lines. It covers the creation of the Service Force, Pacific Fleet (ServPac) and regional base networks.""",
      fillins = """- **Theater Logistics:**
  - General MacArthur's SWPA logistics was centered around the Services of Supply, SWPA, commanded by Major General `[___________]`.
  - ServPac introduced "mobile service bases" utilizing concrete barges and auxiliary ships, which at their peak in late 1944 numbered over `[___________]` vessels.""",
      mermaid = """```mermaid
graph TD
    POA[Pacific Ocean Areas - Nimitz] --> ServPac[Service Force Pacific Fleet]
    SWPA[Southwest Pacific - MacArthur] --> USASOS[US Army Services of Supply SWPA]
```""",
      mathExplanation = """Decentralized logistics networks route supplies from regional hubs to advance bases. We model the distribution cost ($C_{dist}$) as a sum of transit distances weighted by supply volume.""",
      mathFormula = """C_{dist} = \sum_{i} V_i \cdot D_i""",
      scalaCode = """package Logistics.PacificTheaters

case class SupplyRoute(volumeTons: Double, distanceMiles: Double)

object DecentralizedLogisticsNetwork:
  def totalDistributionCost(routes: List[SupplyRoute]): Double =
    routes.map(r => r.volumeTons * r.distanceMiles).sum""",
      discussionQuestions = """1. Contrast the Navy's "mobile base" concept (ServPac) with the Army's "fixed land base" concept in the Pacific. What were the logistical advantages of each?
2. How did the division of the Pacific into SWPA and POA lead to competing demands for shipping, and how was this conflict managed?"""
    ),
    Chapter(
      id = 19,
      title = "Shipping in the Pacific War",
      filename = "19-Shipping-in-the-Pacific-War.md",
      context = """Shipping was the lifeblood of the Pacific campaigns. Because voyages were incredibly long, ships spent a high percentage of their time in transit or waiting to discharge cargo at primitive island anchorages, leading to the "retention" of precious hulls in theater.""",
      fillins = """- **Pacific Shipping Metrics:**
  - The average round-trip turnaround time for a cargo ship from the US West Coast to the Southwest Pacific in 1944 was `[___________]` days.
  - In mid-1944, an average of `[___________]` merchant vessels were "retained" in Pacific theaters as floating warehouses because of a lack of shore depots.""",
      mermaid = """```mermaid
graph TD
    US_WestCoast[US West Coast POEs] -- "30-40 Days Transit" --> Pac_Bases[Pacific Island Bases]
    Pac_Bases --> PortCongestion{Port Congestion / Floating Storage}
    PortCongestion -- "No Shore Storage" --> ShipRetained[Ship Retained: Floating Depot]
    PortCongestion -- "Clear Shore" --> ShipReturned[Ship Returns to US]
```""",
      mathExplanation = """To sustain a constant daily delivery ($D_{target}$) at an island base given a ship's turnaround time ($T_{cycle}$) and average cargo capacity ($C$), we calculate the total fleet size ($N$) required.""",
      mathFormula = """N = \frac{D_{target} \cdot T_{cycle}}{C}""",
      scalaCode = """package Logistics.PacificShipping

case class FleetTarget(dailyTonsTarget: Double, shipCapacityTons: Double)

object FleetSustenanceModel:
  def requiredHulls(target: FleetTarget, turnaroundDays: Double): Int =
    val dailyShipsNeeded = target.dailyTonsTarget / target.shipCapacityTons
    Math.ceil(dailyShipsNeeded * turnaroundDays).toInt""",
      discussionQuestions = """1. Explain the phenomenon of "floating storage" in the Pacific. Why did theater commanders refuse to release cargo ships, and how did this impact global Allied strategy?
2. What measures did the War Shipping Administration (WSA) take to reduce turnaround times in Pacific ports?"""
    ),
    Chapter(
      id = 20,
      title = "Supplying the Army in Pacific Theaters",
      filename = "20-Supplying-the-Army-in-Pacific-Theaters.md",
      context = """This chapter details the specific tactical supply problems encountered by the Army in tropical climates: food spoilage, mold, mildew, rust, and the physical breakdown of packaging. It highlights the development of specialized "jungle rations" and waterproofing techniques.""",
      fillins = """- **Tropical Logistics:**
  - The humidity and heat of the New Guinea jungle caused an estimated loss of `[___________]`% of all stored flour and dry rations within 3 months.
  - The development of "Type C" and "Type K" rations provided combat troops with portable nutrition, but prolonged consumption led to average weight losses of `[___________]` lbs per man.""",
      mermaid = """```mermaid
graph TD
    Arrive_Base[Supplies Arrive at Base] --> Open_Storage[Open-Air Depots: Rain & Humidity]
    Open_Storage --> Spoilage[Fungal Rot & Rust]
    Open_Storage --> Salvage[Salvage & Repackaging]
```""",
      mathExplanation = """We model the spoilage and degradation of supply stocks in tropical environments using an exponential decay model where the shelf-life ($S$) is a function of humidity and temperature degradation factor ($\alpha$).""",
      mathFormula = """S_t = S_0 \cdot e^{-\alpha \cdot t}""",
      scalaCode = """package Logistics.SupplyingPacific

import scala.math.exp

case class SupplyStock(initialTons: Double, decayRate: Double)

object SpoilageDepreciationModel:
  def remainingStock(stock: SupplyStock, months: Double): Double =
    stock.initialTons * exp(-stock.decayRate * months)""",
      discussionQuestions = """1. How did the lack of refrigerated storage (reefer ships and warehouses) limit the diet and morale of troops in the Southwest Pacific?
2. What innovations in packaging (such as laminated foils and dipping waxes) were developed to protect ammunition and medical supplies from moisture?"""
    ),
    Chapter(
      id = 21,
      title = "China, Burma, and India",
      filename = "21-China-Burma-and-India.md",
      context = """The China-Burma-India (CBI) theater was a logistical nightmare. Following the Japanese closure of the Burma Road, the only link to China was "The Hump" airlift over the Himalayas. This chapter examines the extreme trade-offs between flying cargo to China versus building the overland Ledo Road.""",
      fillins = """- **CBI Logistical Constraints:**
  - "The Hump" airlift was managed by the Army Air Forces ATC, reaching a peak delivery of `[___________]` tons per month in late 1944.
  - For every 100 tons of fuel flown over the Hump to fuel Chennault's Fourteenth Air Force, the transport aircraft themselves consumed `[___________]` tons of fuel during the round trip.""",
      mermaid = """```mermaid
graph TD
    India_Depots[Assam Depots, India] --> Hump_Airlift[The Hump Air Route]
    Hump_Airlift -- "Fuel Burned in Transit" --> China_Bases[Kunming, China: Net Payload Recd]
    India_Depots --> Ledo_Road[Ledo Road Construction]
```""",
      mathExplanation = """Airlift efficiency in the CBI can be modeled as a fuel-to-cargo ratio. Let $F_{burn}$ be the fuel burned by the transport plane, $C_{max}$ be the maximum payload capacity, and $D$ be the route distance. The net cargo delivered ($C_{net}$) is the payload capacity minus the transit fuel required for the round trip.""",
      mathFormula = """C_{net} = C_{max} - F_{burn}(D)""",
      scalaCode = """package Logistics.CBI

case class AircraftSpecs(maxPayloadLbs: Double, fuelBurnLbsPerHour: Double)

object AirliftEfficiencyModel:
  def netCargoDelivered(
    specs: AircraftSpecs,
    flightDurationHours: Double,
    roundTrip: Boolean
  ): Double =
    val multiplier = if roundTrip then 2.0 else 1.0
    val transitFuel = specs.fuelBurnLbsPerHour * flightDurationHours * multiplier
    specs.maxPayloadLbs - transitFuel""",
      discussionQuestions = """1. Explain the "Hump Paradox": Why was the airlift considered an inefficient use of resources, and why did General Marshall continue to support it?
2. Describe Stilwell's strategic vision for the Ledo Road and how it conflicted with Chennault's air-centric strategy for China."""
    ),
    Chapter(
      id = 22,
      title = "Stresses and Strains of a Two-Front War",
      filename = "22-Stresses-and-Strains-of-a-Two-Front-War.md",
      context = """By mid-1944, the US was waging full-scale offensives in both Europe and the Pacific. This chapter examines the global competition for resources (such as artillery ammunition, heavy trucks, and engineering equipment) that strained the US industrial base to its absolute limits.""",
      fillins = """- **Global Ammunition & Vehicle Crisis:**
  - The monthly demand for 105mm artillery ammunition in Europe in late 1944 reached `[___________]` rounds, far exceeding the planned production of `[___________]` rounds.
  - The global shortage of heavy tactical trucks (4-to-10 ton class) in late 1944 was estimated at `[___________]` units.""",
      mermaid = """```mermaid
graph TD
    US_Production[US Industrial Base] --> JCS_Global{Global Allocation}
    JCS_Global -- "ETO Priority" --> Eisenhower[European Theater]
    JCS_Global -- "Pac Priority" --> MacArthur_Nimitz[Pacific Theaters]
```""",
      mathExplanation = """We model global resource allocation as a multi-objective linear programming problem where we maximize overall combat readiness across two fronts under production constraints.""",
      mathFormula = """\text{Maximize } U = a \cdot X_{ETO} + b \cdot X_{PAC} \quad \text{subject to } X_{ETO} + X_{PAC} \le P_{total}""",
      scalaCode = """package Logistics.TwoFrontWar

case class ProductionLimits(totalOutput: Double)

object DualFrontOptimizer:
  def optimalSplit(
    limits: ProductionLimits,
    etoWeight: Double,
    pacWeight: Double
  ): (Double, Double) =
    val sum = etoWeight + pacWeight
    val etoAlloc = (etoWeight / sum) * limits.totalOutput
    val pacAlloc = (pacWeight / sum) * limits.totalOutput
    (etoAlloc, pacAlloc)""",
      discussionQuestions = """1. Why did the Allied planners underestimate the requirement for artillery ammunition in Europe, and what measures were taken in late 1944 to increase production?
2. How did the JCS handle the competing demands for heavy engineering equipment (such as bulldozers) between the Pacific base developers and the European reconstruction teams?"""
    ),
    Chapter(
      id = 23,
      title = "The Pacific in Transition",
      filename = "23-The-Pacific-in-Transition.md",
      context = """In late 1944, the Pacific campaigns accelerated with the invasion of the Philippines (Leyte and Luzon). This chapter covers the massive logistical shift as bases were moved forward from New Guinea and the Marianas to support the re-entry into the Philippines.""",
      fillins = """- **Philippine Campaign Logistics:**
  - The invasion of Leyte (Operation KING II) was launched on `[___________]`.
  - The assault convoy carried over `[___________]` troops and `[___________]` tons of cargo.
  - The transition of bases forward required shipping `[___________]` measurement tons of base construction materials to Leyte alone.""",
      mermaid = """```mermaid
graph TD
    New_Guinea[Rear Bases: New Guinea] --> Leyte_Beach[Leyte Assault & Base Setup]
    Marianas[Marianas Bases] --> Leyte_Beach
    Leyte_Beach --> Luzon[Planning for Luzon Invasions]
```""",
      mathExplanation = """Shifting logistical centers of gravity involves relocations. We model the base relocation transit cost ($C_{reloc}$) as a function of cargo volume ($V$), distance ($D$), and setup time delay ($S$).""",
      mathFormula = """C_{reloc} = V \cdot (D \cdot T_{transit} + S)""",
      scalaCode = """package Logistics.PacificTransition

case class BaseSpecs(cargoVolumeTons: Double, setupDays: Double)

object BaseRelocationModel:
  def relocationCost(
    specs: BaseSpecs,
    distanceMiles: Double,
    transitTimePerMileDay: Double
  ): Double =
    specs.cargoVolumeTons * (distanceMiles * transitTimePerMileDay + specs.setupDays)""",
      discussionQuestions = """1. Describe the logistical challenges of setting up major supply bases on Leyte during the monsoon season.
2. How did the capture of the Marianas (Saipan, Tinian, Guam) alter the logistical support of the strategic B-29 bombing campaign against Japan?"""
    ),
    Chapter(
      id = 24,
      title = "Logistics of a One-Front War",
      filename = "24-Logistics-of-a-One-Front-War.md",
      context = """As the defeat of Germany became imminent in early 1945, planners shifted their focus to a "One-Front War" model. This required planning for "Redirection" (diverting ETO-bound supply ships directly to the Pacific) and the massive redeployment of millions of troops from Europe to the Pacific (Operation Redeployment).""",
      fillins = """- **Redeployment Plans:**
  - The planned redeployment scheme (after V-E Day) envisioned moving `[___________]` million soldiers from Europe to the Pacific within 12 months.
  - Shipping planners calculated that they would need to redirect over `[___________]` cargo ships already in transit or loading.""",
      mermaid = """```mermaid
graph TD
    Europe_Force[ETO Troops & Cargo] --> Port_Discharge[Port of Embarkation: Europe]
    Port_Discharge --> Suez_Route[Suez Canal Route]
    Port_Discharge --> US_Staging[US Staging Areas: Redeployment]
    US_Staging --> Pac_Dest[Pacific Theater Destinations]
```""",
      mathExplanation = """Redirection of cargo in transit can be modeled as vector redirection. We calculate the extra distance ($D_{extra}$) added when rerouting a cargo ship from ETO paths to Pacific ports via the Panama Canal.""",
      mathFormula = """D_{extra} = D_{US-to-Pacific} - D_{US-to-Europe}""",
      scalaCode = """package Logistics.OneFrontWar

case class RouteDistances(usToEurope: Double, usToPacific: Double)

object RouteRedirectionModel:
  def extraDistanceMiles(routes: RouteDistances): Double =
    routes.usToPacific - routes.usToEurope""",
      discussionQuestions = """1. Why did the "Redirection" of cargo ships in mid-1945 prove to be one of the most complex scheduling tasks ever attempted by the War Shipping Administration?
2. What were the psychological and physical impacts on ETO veteran troops scheduled for immediate redeployment to the Pacific?"""
    ),
    Chapter(
      id = 25,
      title = "Lend-Lease and the Common Pool",
      filename = "25-Lend-Lease-and-the-Common-Pool.md",
      context = """Lend-Lease was not a one-way street but a "Common Pool" of resources. This chapter explores the financial and physical mechanics of Lend-Lease, focusing on the pooling of merchant shipping (the "shipping pool") and "Reverse Lend-Lease" (reciprocal aid provided by the British and other allies to US forces).""",
      fillins = """- **Lend-Lease Financials:**
  - By the end of 1944, total US Lend-Lease aid exceeded `[___________]` billion dollars.
  - Reverse Lend-Lease provided by the United Kingdom to the US Army (including barracks, airfields, and local food) was valued at `[___________]` billion dollars.""",
      mermaid = """```mermaid
graph TD
    US_Industrial[US Production] --> Pool{The Common Pool}
    Pool -- "Lend-Lease" --> Allies[UK, USSR, China]
    Allies -- "Reverse Lend-Lease" --> US_Forces[US Forces in Theater]
```""",
      mathExplanation = """Bilateral resource-exchange can be modeled as a trade matrix. Let $L_{ij}$ be the value of resources transferred from nation $i$ to nation $j$. The net transfer balance ($B_i$) for any country is computed to verify contribution values.""",
      mathFormula = """B_i = \sum_{j} L_{ij} - \sum_{j} L_{ji}""",
      scalaCode = """package Logistics.LendLease

case class TradeFlow(source: String, destination: String, valueBillions: Double)

object ReverseLendLeaseMatrix:
  def netBalance(country: String, flows: List[TradeFlow]): Double =
    val outFlow = flows.filter(_.source == country).map(_.valueBillions).sum
    val inFlow = flows.filter(_.destination == country).map(_.valueBillions).sum
    outFlow - inFlow""",
      discussionQuestions = """1. How did the concept of the "Common Pool" challenge traditional ideas of national sovereignty and military procurement?
2. Detail the strategic value of "Reverse Lend-Lease" in minimizing the shipping tonnage the US had to send to England and Australia."""
    ),
    Chapter(
      id = 26,
      title = "The End of the Common Pool",
      filename = "26-The-End-of-the-Common-Pool.md",
      context = """This chapter covers the political and logistical wind-down of Lend-Lease in 1945. Following the surrender of Germany, the US rapidly reduced Lend-Lease deliveries to European allies, leading to severe diplomatic tension as nations struggled with reconstruction.""",
      fillins = """- **Lend-Lease Termination:**
  - President Truman signed the executive order terminating Lend-Lease on `[___________]`.
  - The sudden cutoff left over `[___________]` tons of cargo sitting on US docks, originally destined for Great Britain.""",
      mermaid = """```mermaid
graph TD
    V_E_Day[V-E Day: May 1945] --> Red_Aid[Reduce Aid to Europe]
    V_J_Day[V-J Day: Aug 1945] --> Cutoff_Order[Executive Cutoff Order]
    Cutoff_Order --> Port_Piles[Piles of Undelivered Cargo at POEs]
```""",
      mathExplanation = """The pool drawdown can be modeled as an exponential decay function where supply deliveries ($D$) drop rapidly following strategic milestone dates ($t$).""",
      mathFormula = """D_t = D_{peak} \cdot e^{-k \cdot (t - t_{VE})}""",
      scalaCode = """package Logistics.EndCommonPool

import scala.math.exp

case class DrawdownParameters(peakDelivery: Double, decayRate: Double)

object DrawdownCurve:
  def deliveryAtTime(params: DrawdownParameters, monthsPostVE: Double): Double =
    if monthsPostVE >= 0 then
      params.peakDelivery * exp(-params.decayRate * monthsPostVE)
    else
      params.peakDelivery""",
      discussionQuestions = """1. Why did the sudden termination of Lend-Lease surprise the British government, and what were the immediate economic consequences for the UK?
2. How was the transition of shipping from the global pool back to private national fleets managed in late 1945?"""
    ),
    Chapter(
      id = 27,
      title = "Aid to the USSR in the Later War Years",
      filename = "27-Aid-to-the-USSR-in-the-Later-War-Years.md",
      context = """Sustaining the Soviet war effort required massive deliveries of raw materials, vehicles, and industrial machinery. This chapter analyzes the three main routes: the Arctic Convoys (Murmansk/Archangel), the Persian Corridor, and the Soviet-flagged Pacific Route (West Coast to Vladivostok).""",
      fillins = """- **Soviet Aid Metrics:**
  - The Persian Corridor, developed by the US Army's Persian Gulf Command, cleared a peak of `[___________]` tons of cargo per month in 1944.
  - By the end of the war, the US had shipped over `[___________]` tactical trucks and jeep vehicles to the Soviet Union, providing the mobility for the Red Army’s drive to Berlin.""",
      mermaid = """```mermaid
graph TD
    US_Production[US Factories] --> Arctic_Route[Arctic Route: High Risk, Fast]
    US_Production --> Persian_Route[Persian Corridor: Low Risk, Slow]
    US_Production --> Pacific_Route[Pacific Route: Soviet Ships, Medium]
```""",
      mathExplanation = """Selecting the optimal transport route under threat requires risk-weighting. We model the expected cargo delivered ($C_{delivered}$) as a function of transit loss rates ($L_r$) and transit duration ($T$).""",
      mathFormula = """C_{delivered} = C_{initial} \cdot (1 - L_r)""",
      scalaCode = """package Logistics.SovietAid

case class RouteSpecs(name: String, lossRate: Double, transitDays: Double)

object SovietRouteRiskModel:
  def expectedDelivery(initialTons: Double, specs: RouteSpecs): Double =
    initialTons * (1.0 - specs.lossRate)""",
      discussionQuestions = """1. Compare the strategic advantages and physical constraints of the Persian Corridor against the Arctic Route.
2. How did the US-supplied locomotives and rolling stock revolutionize Soviet military rail transport during 1944-45?"""
    ),
    Chapter(
      id = 28,
      title = "Military Supply to Liberated and Latin American Nations",
      filename = "28-Military-Supply-to-Liberated-and-Latin-American-Nations.md",
      context = """This chapter explores the logistics of re-arming Allied nations: equipping French divisions in North Africa, supporting Italian co-belligerent forces, and providing military assistance to Latin American countries. It examines the challenge of standardization when introducing US equipment to foreign forces.""",
      fillins = """- **Re-armament Programs:**
  - The US re-armed `[___________]` French divisions, providing them with standard US uniforms, weapons, and vehicles.
  - Latin American nations received a total of `[___________]` million dollars in Lend-Lease aid, with Brazil receiving the largest share.""",
      mermaid = """```mermaid
graph TD
    US_Arsenals[US Arsenals] --> Allied_Programs[Re-armament Board]
    Allied_Programs --> French_Div[French Army: 8 Divisions]
    Allied_Programs --> Brazilian_FEF[Brazilian Expeditionary Force]
```""",
      mathExplanation = """Standardization checks the compatibility of weapon calibers and replacement parts. We model a compatibility matching system to verify if a foreign division can be sustained using standard US logistics pipelines.""",
      mathFormula = """C = \begin{cases} 1 & \text{if } Caliber_{force} = Caliber_{pipeline} \\ 0 & \text{otherwise} \end{cases}""",
      scalaCode = """package Logistics.LiberatedNations

case class WeaponSystem(name: String, caliberMm: Double, countryOfOrigin: String)

object StandardizationMatcher:
  def isCompatible(system: WeaponSystem, pipelineCaliberMm: Double): Boolean =
    system.caliberMm == pipelineCaliberMm""",
      discussionQuestions = """1. What logistical issues arose from the French army's desire to maintain their traditional organizational structure while using American-made equipment?
2. Analyze the strategic reasons behind providing military aid to Latin American nations during World War II."""
    ),
    Chapter(
      id = 29,
      title = "Lend-Lease to China, 1943-45",
      filename = "29-Lend-Lease-to-China-1943-45.md",
      context = """Following the opening of the Ledo Road (renamed the Stilwell Road) and the expansion of the pipeline, Lend-Lease to China increased. This chapter examines the physical movement of supplies from Calcutta ports, through Assam, and across the border to Chinese armies.""",
      fillins = """- **China Lend-Lease:**
  - The first truck convoy over the opened Stilwell Road arrived in Kunming, China, on `[___________]`.
  - The total tonnage of Lend-Lease supplies delivered to China via overland and air routes in 1944 was `[___________]` tons, which increased to `[___________]` tons in 1945.""",
      mermaid = """```mermaid
graph TD
    Calcutta_Port[Port of Calcutta] --> Assam_Rail[Assam Railway]
    Assam_Rail --> Stilwell_Road[Stilwell / Ledo Road]
    Stilwell_Road --> Kunming_Hub[Kunming Supply Hub]
```""",
      mathExplanation = """Road convoy capacity is constrained by the number of operational trucks, fuel depots along the route, and road maintenance capabilities. We model the daily tonnage capacity ($T_{road}$) of a single-lane wilderness highway.""",
      mathFormula = """T_{road} = \frac{N_{trucks} \cdot Capacity_{truck}}{Interval_{days} + T_{transit}}""",
      scalaCode = """package Logistics.ChinaLendLease

case class ConvoyParameters(trucks: Int, avgPayloadTons: Double, transitDays: Double)

object RoadConvoyCapacity:
  def dailyCapacity(params: ConvoyParameters, dispatchIntervalDays: Double): Double =
    val totalTime = params.transitDays + dispatchIntervalDays
    (params.trucks * params.avgPayloadTons) / totalTime""",
      discussionQuestions = """1. Why did the opening of the Stilwell Road occur so late in the war, and did its strategic value justify the massive engineering effort?
2. How did the Chinese currency inflation affect the local procurement of supplies by US Army units in China?"""
    ),
    Chapter(
      id = 30,
      title = "The Army and Civilian Supply: I",
      filename = "30-The-Army-and-Civilian-Supply-I.md",
      context = """As Allied armies liberated territory in Europe, they immediately encountered starving populations, collapsed public utilities, and the threat of disease. This chapter examines the Army’s "Civil Affairs" branch (G-5) and the logistics of distributing emergency food, coal, and medicine to liberated populations.""",
      fillins = """- **Civilian Relief in Europe:**
  - The emergency civilian feeding program in Naples, Italy, required importing `[___________]` tons of wheat per month to prevent starvation.
  - The basic relief ration target established by the Allied military government for liberated European civilians was `[___________]` calories per person per day.""",
      mermaid = """```mermaid
graph TD
    Military_Gov[Allied Military Government G-5] --> Relief_Stocks[Relief Stocks: Flour, Sugar, Milk]
    Relief_Stocks --> Local_Distribution[Local Municipal Depots]
    Local_Distribution --> Civilian_Rations[Civilian Rationing: 1500-2000 Calories]
```""",
      mathExplanation = """Calculating caloric relief requirements models the total tonnage of food imports needed ($T_{food}$) based on population size ($P$) and daily caloric target ($C$).""",
      mathFormula = """T_{food} = \frac{P \cdot C \cdot 30}{K_{calories/ton}}""",
      scalaCode = """package Logistics.CivilianSupplyI

opaque type Population = Int
object Population:
  def apply(value: Int): Population = value
  extension (p: Population) def toInt: Int = p

object CaloricReliefModel:
  def calculateTonnageRequired(
    pop: Population,
    caloricTarget: Double,
    caloriesPerTon: Double
  ): Double =
    val dailyCaloricTotal = pop.toInt * caloricTarget
    val monthlyCaloricTotal = dailyCaloricTotal * 30.0
    monthlyCaloricTotal / caloriesPerTon""",
      discussionQuestions = """1. Why did the War Department accept responsibility for feeding civilian populations in combat zones? What was the "prevent disease and unrest" doctrine?
2. Detail the logistical difficulties of distributing coal to the French population during the freezing winter of 1944-45.""""
    ),
    Chapter(
      id = 31,
      title = "The Army and Civilian Supply: II",
      filename = "31-The-Army-and-Civilian-Supply-II.md",
      context = """This chapter expands on civilian supply, analyzing the complex logistics of relief in Asian and Pacific regions (including liberated Manila and Korea) and the transition of responsibility from the military to civilian organizations like the United Nations Relief and Rehabilitation Administration (UNRRA).""",
      fillins = """- **Global Relief Operations:**
  - The transition of relief responsibility from the US Army to UNRRA in Europe took place on `[___________]`.
  - In Manila, after its liberation in early 1945, the US Army distributed over `[___________]` tons of food to the destitute population within the first month.""",
      mermaid = """```mermaid
graph TD
    Mil_Dist[Military G-5 Relief Phase] --> Transition_Event{Transition Date}
    Transition_Event --> UNRRA_Dist[UNRRA Relief Phase]
    Transition_Event --> Civil_Gov[Local Civil Government]
```""",
      mathExplanation = """Relief distribution queues model civilian wait times at supply stations. We model the average queue size ($L_q$) using basic queueing theory parameters.""",
      mathFormula = """L_q = \frac{\lambda^2}{\mu \cdot (\mu - \lambda)}""",
      scalaCode = """package Logistics.CivilianSupplyII

case class DistributionStation(arrivalRatePerMin: Double, serviceRatePerMin: Double)

object ReliefDistributionQueue:
  def averageQueueLength(station: DistributionStation): Double =
    val l = station.arrivalRatePerMin
    val m = station.serviceRatePerMin
    if m > l then
      (l * l) / (m * (m - l))
    else
      Double.PositiveInfinity""",
      discussionQuestions = """1. What organizational differences made the transition from military G-5 supply to UNRRA control difficult?
2. Compare the logistical challenges of civilian relief in a highly urbanized European setting with a devastated Pacific archipelago like the Philippines."""
    ),
    Chapter(
      id = 32,
      title = "Logistics and Strategy in World War II",
      filename = "32-Logistics-and-Strategy-in-World-War-II.md",
      context = """The concluding chapter synthesizes the grand lessons of World War II logistics. It reviews how logistics ceased to be a secondary service of support and became the primary determinant of grand strategy, dictating when, where, and with what force the Allied nations could strike.""",
      fillins = """- **The Grand Synthesis:**
  - Over the course of the war, the US Army shipped a total of `[___________]` million long tons of cargo overseas.
  - The total cost of the US Army's logistical operations was estimated to represent `[___________]`% of the nation's total war expenditure.
  - The peak overseas troop strength of the US Army reached `[___________]` million men in 1945.""",
      mermaid = """```mermaid
graph TD
    Grand_Strategy[Grand Strategy: President/Prime Minister/Stalin] --> Log_Limits{Logistical Feasibility Boundaries}
    Log_Limits -- "Feasible" --> Operational_Execution[Operational Execution]
    Log_Limits -- "Infeasible" --> Strategic_Revision[Strategic Revision]
```""",
      mathExplanation = """Logistical power can be modeled as the correlation between total theater tonnage delivered ($T_{theater}$) and the overall combat power ($P_{combat}$) of the divisions in contact.""",
      mathFormula = """P_{combat} = \alpha \cdot T_{theater} \cdot N_{divisions}""",
      scalaCode = """package Logistics.Conclusion

case class TheaterState(tonnageDelivered: Double, divisionsInContact: Int)

object LogisticsCorrelationModel:
  def calculateCombatPowerIndex(
    state: TheaterState,
    efficiencyCoefficient: Double
  ): Double =
    efficiencyCoefficient * state.tonnageDelivered * state.divisionsInContact.toDouble""",
      discussionQuestions = """1. In what ways did World War II redefine the relationship between a nation’s industrial capacity and its battlefield tactics?
2. Assess the statement: "Logistics is the science of military planning; strategy is merely the art of the possible." How does the Green Book support this view?"""
    )
  )

  def main(args: Array[String]): Unit =
    val targetDir = Paths.get("prompts")
    if (!Files.exists(targetDir)) {
      Files.createDirectories(targetDir)
      println("Created prompts directory.")
    }

    chapters.foreach { ch =>
      // Using raw interpolator to preserve single backslashes in mathFormula
      val content = raw"""# Chapter ${ch.id}: ${ch.title}

## 1. Context & Core Themes
${ch.context}

---

## 2. Interactive Study Fill-ins (Details to Fill In)
*To complete your study of this chapter, research and fill in the missing metrics below:*

${ch.fillins}

---

## 3. Logistical Architecture (Mermaid.js Diagram)
Complete or extend this diagram depicting the logistical workflows, command hierarchies, or pipelines of this chapter.

${ch.mermaid}

---

## 4. Quantitative Modeling: ${ch.title}
${ch.mathExplanation}

### Mathematical Formulation
$$${ch.mathFormula}$$

### Scala 3.8.3 Implementation
Below is the compile-safe Scala 3.8.3 model representing these parameters:

```scala
${ch.scalaCode}
```

---

## 5. Strategic Discussion Questions
${ch.discussionQuestions}
"""
      
      val filePath = targetDir.resolve(ch.filename)
      Files.write(filePath, content.getBytes(StandardCharsets.UTF_8))
      println(s"Generated: ${ch.filename}")
    }
    println("All 32 chapter prompts have been successfully generated.")
