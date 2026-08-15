package Logistics.Generator

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets

case class Chapter(
  id: Int,
  title: String,
  filename: String,
  eraContext: String,
  analyticalFocus: String,
  simulationFocus: String,
  mathFormulaIdea: String,
  startingScalaInterface: String,
  strategicQuestions: List[String],
  keyMetricsToAsk: List[String]
)

object PromptGenerator:
  val chapters: List[Chapter] = List(
    Chapter(
      id = 1,
      title = "Logistics and Strategy, Spring 1943",
      filename = "01-Logistics-and-Strategy-Spring-1943.md",
      eraContext = "Following the Casablanca Conference (ANFA) in January 1943, Allied strategy focused on resolving the fundamental tension between the BOLERO build-up in the UK, continuation of Mediterranean operations (HUSKY), and the ongoing critical tonnage requirements of the Pacific and Lend-Lease.",
      analyticalFocus = "Modern scholarship demonstrates that the global merchant shipping pool was the single ultimate constraint on Allied grand strategy. Planners at Casablanca grossly overestimated ship turnaround times and cargo discharge rates. In March 1943, the Battle of the Atlantic peaked with U-boat sinkings threatening to completely paralyze the BOLERO build-up.",
      simulationFocus = "Convoy Turnaround Time and Pipeline Throughput. Modeling transit speeds, port loading/unloading delays, and convoy assembly intervals to determine net cargo capacity delivered over time.",
      mathFormulaIdea = "T_{cycle} = \\frac{2 \\cdot D}{24 \\cdot V} + L_{port} + U_{port} + D_{convoy}",
      startingScalaInterface = """package Logistics.Spring1943

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
      strategicQuestions = List(
        "Why did the high troop-to-service ratio in Spring 1943 limit the offensive capability of the Allied armies in the Mediterranean?",
        "Detail how the 'ship-against-division' calculation influenced General George C. Marshall’s strategy regarding the timing of Operation OVERLORD."
      ),
      keyMetricsToAsk = List(
        "Target BOLERO monthly troop shipment rate vs. actual March 1943 shipments.",
        "Total deadweight tonnage (dwt) of the Allied global ocean-going merchant shipping pool in Spring 1943.",
        "Net merchant cargo tonnage lost due to German U-boat attacks in the Atlantic in March 1943."
      )
    ),
    Chapter(
      id = 2,
      title = "Husky and Bolero",
      filename = "02-Husky-and-Bolero.md",
      eraContext = "The planning for the invasion of Sicily (Operation HUSKY) in mid-1943 directly conflicted with the BOLERO build-up in the United Kingdom. This chapter highlights the critical shortage of amphibious shipping, specifically LSTs (Landing Ship, Tank), LCIs, and LCTs, and the struggle to balance short-term tactical operations against long-term strategic build-up.",
      analyticalFocus = "Modern analysis reveals that the shortage of landing craft was exacerbated by competing demands from the Pacific theater, which Nimitz and MacArthur claimed were non-negotiable. Furthermore, combat loading of vessels (which reduced effective cargo capacity by up to 60%) was not fully factored into early transit models, leading to severe logistical shortfalls in Sicily.",
      simulationFocus = "Resource Allocation Under Theater Constraints. Optimizing the split of a finite landing craft pool between HUSKY (MTO) and BOLERO (ETO) to meet minimum tactical assault and strategic build-up thresholds.",
      mathFormulaIdea = "X_{H} + X_{B} \\le C_{total}, \\quad X_{H} \\ge X_{H}^{min}, \\quad X_{B} \\ge X_{B}^{min}",
      startingScalaInterface = """package Logistics.HuskyBolero

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
      strategicQuestions = List(
        "How did the British and American viewpoints differ at the Washington Conference regarding the trade-offs between HUSKY and BOLERO?",
        "What role did the 'Anvil' (later 'Dragoon') debate play in the landing craft allocation disputes of early 1943?",
        "Explain how the introduction of the 2.5-ton amphibious truck (DUKW) mitigated port discharge limitations during HUSKY."
      ),
      keyMetricsToAsk = List(
        "Total LSTs required for HUSKY assault vs. LSTs withdrawn from the BOLERO pool.",
        "May 1943 actual troop strength in the United Kingdom vs. the original BOLERO target.",
        "Effective cargo carrying capacity reduction percentage of a combat-loaded troop transport compared to an administratively loaded merchant ship."
      )
    ),
    Chapter(
      id = 3,
      title = "The TRIDENT Conference",
      filename = "03-The-TRIDENT-Conference.md",
      eraContext = "The TRIDENT Conference (Washington, May 1943) established global Allied strategy for the rest of 1943 and early 1944. It forced a critical evaluation of resource distribution between the European Theater of Operations (ETO), the Mediterranean (MTO), and the Pacific, balancing political pressures and material realities.",
      analyticalFocus = "TRIDENT formalized the target date of May 1. 1944 for Operation OVERLORD. From a modern systems perspective, this decision established a hard timeline constraint on all global pipelines, making every other theater a secondary competitor for resources, particularly landing craft and heavy troop ships.",
      simulationFocus = "Multi-Theater Priority and Weighted Resource Distribution. Modeling resource split based on theater-specific strategic weights and distance-related transit efficiency degradation.",
      mathFormulaIdea = "S_i = \\frac{W_i \\cdot (1 - \\theta_i)}{\\sum_{j} W_j \\cdot (1 - \\theta_j)} \\cdot C_{total}",
      startingScalaInterface = """package Logistics.Trident

import scala.collection.immutable.Map

case class Theater(name: String, weight: Double, distancePenalty: Double)

object TridentPrioritization:
  def allocateSupplies(
    theaters: List[Theater],
    totalSupplies: Double
  ): Map[String, Double] =
    val totalWeight = theaters.map(t => t.weight * (1.0 - t.distancePenalty)).sum
    if totalWeight <= 0.0 then Map.empty
    else
      theaters.map { t =>
        val adjustedWeight = t.weight * (1.0 - t.distancePenalty)
        t.name -> (adjustedWeight / totalWeight) * totalSupplies
      }.toMap""",
      strategicQuestions = List(
        "How did TRIDENT resolve the fundamental disagreement between Roosevelt and Churchill on the expansion of Mediterranean operations?",
        "To what extent did Pacific shipping requirements limit the ETO troop build-up scheduled at TRIDENT?"
      ),
      keyMetricsToAsk = List(
        "Approved OVERLORD assault division target size at TRIDENT.",
        "Authorized Pacific air strength expansion (in squadrons) approved at TRIDENT.",
        "Calculated shipping allocation (tons/month) required to support Cartwheel and Central Pacific operations in mid-1943."
      )
    ),
    Chapter(
      id = 4,
      title = "Logistical Organization",
      filename = "04-Logistical-Organization.md",
      eraContext = "This chapter details the restructuring of the Army Service Forces (ASF) under Lt. Gen. Brehon B. Somervell and the creation of Theater of Operations structures (ETOUSA, Services of Supply in Europe). It highlights the massive organizational friction of managing wholesale logistics across globally dispersed commands.",
      analyticalFocus = "Modern administrative theory highlights the systemic friction between Somervell's highly centralized ASF in Washington and the decentralized command desires of theater commanders like Eisenhower. Command structures like the Communications Zone (ComZ) had to balance multiple layers of base, intermediate, and advance sections to prevent severe bottleneck duplication.",
      simulationFocus = "Command Chain Communication and Processing Latency. Modeling the administrative delay of supply requests through a hierarchical command tree.",
      mathFormulaIdea = "L = D \\cdot \\log_e(S) + T_{processing}",
      startingScalaInterface = """package Logistics.Organization

import scala.math.log

case class Hierarchy(depth: Int, spanOfControl: Int)

object OrganizationModel:
  def calculateCommunicationLatency(
    h: Hierarchy,
    processingDelay: Double
  ): Double =
    if h.spanOfControl <= 0 then processingDelay
    else h.depth * log(h.spanOfControl.toDouble) + processingDelay""",
      strategicQuestions = List(
        "Discuss the command conflicts between General Eisenhower (as Theater Commander) and General Somervell (as ASF Commander) regarding control over logistics in North Africa and England.",
        "How did the division of the theater into Base, Intermediate, and Advance Sections prevent double-handling of materials?"
      ),
      keyMetricsToAsk = List(
        "Date of Services of Supply (SOS) redesignation to Communications Zone (ComZ) in the ETO.",
        "Number of Technical Services consolidated under Somervell's ASF reorganization.",
        "Authorized civilian personnel strength of the ASF in late 1943 to handle wholesale procurement."
      )
    ),
    Chapter(
      id = 5,
      title = "Army Requirements, 1943-44",
      filename = "05-Army-Requirements-1943-44.md",
      eraContext = "Determining the material requirements for an army of millions of men required predicting future combat conditions, equipment replacement factors, and maintenance pipelines. This chapter covers the compilation of the 'Victory Program' and the formulation of the Troop Basis and Supply Scales.",
      analyticalFocus = "Requirements planning was a massive predictive systems problem. Overestimating combat loss factors (replacement factors) led to the 'overstocking' crisis of late 1943, filling English depots with unused equipment (like tank tracks and spare parts) that choked local inland transportation networks.",
      simulationFocus = "Demand Forecasting and Requirements Planning. Modeling required tonnage based on troop strength, daily supply factors, and combat replacement buffers.",
      mathFormulaIdea = "R_{month} = \\left( P \\cdot F_{day} \\cdot 30 \\right) \\cdot (1 + B)",
      startingScalaInterface = """package Logistics.Requirements

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
      strategicQuestions = List(
        "Explain how the discrepancy between 'production capability' (WPB) and 'military requirements' (ASF) was resolved in the mid-war period.",
        "What are the dangers of overestimating replacement factors, and how did it lead to the 'overstocking' crisis of late 1943?"
      ),
      keyMetricsToAsk = List(
        "Standard daily maintenance requirement (lbs/soldier/day) in 1943.",
        "Maximum authorized troop strength (Troop Basis) for the US Army in 1943.",
        "Combat replacement factor (percentage/month) for medium tanks in requirements planning."
      )
    ),
    Chapter(
      id = 6,
      title = "The Mechanics of Wholesale Distribution",
      filename = "06-The-Mechanics-of-Wholesale-Distribution.md",
      eraContext = "This chapter explores the physical mechanics of logistics: moving supplies from US factories to depots, port clearances, and cargo loading. It introduces the vital concepts of balanced cargo loading (combining heavy and volumetric cargo) to maximize the utilization of ship capacity.",
      analyticalFocus = "Cargo optimization must balance weight and volume constraints. Ships have both a deadweight lift limit and a cubic bale capacity limit. If a cargo planner loads only steel and ammunition, the ship will reach its weight limit but leave 50% of its volume empty (sinking the ship to its draft lines). Conversely, loading only trucks or aircraft leaves the ship extremely light but completely full of volume. 'Balanced loading' stowed heavy materials in the lower holds and light, bulky materials in the upper decks.",
      simulationFocus = "Balanced Ship Loading (Knapsack-like Linear Optimization). Maximizing cargo throughput under joint weight and volume constraints.",
      mathFormulaIdea = "S_f \\cdot M_{heavy} + S_l \\cdot M_{light} \\le V_{max} \\quad \\text{and} \\quad M_{heavy} + M_{light} \\le W_{max}",
      startingScalaInterface = """package Logistics.Distribution

case class VesselConstraints(weightCapacityTons: Double, volumeCapacityCuFt: Double)
case class CargoProperties(heavyStowageFactor: Double, lightStowageFactor: Double)

object DistributionOptimizer:
  def calculateMaxCargo(
    v: VesselConstraints,
    c: CargoProperties
  ): (Double, Double) =
    val heavy = (v.volumeCapacityCuFt - v.weightCapacityTons * c.lightStowageFactor) / 
                (c.heavyStowageFactor - c.lightStowageFactor)
    val light = v.weightCapacityTons - heavy
    (heavy, light)""",
      strategicQuestions = List(
        "What was the purpose of the 'Holding and Reconsignment Points' (H&RPs) in the US railroad transport system, and how did they prevent port congestion?",
        "Detail the difference between 'Measurement Tons' (40 cubic feet) and 'Long Tons' (2240 lbs), and why this distinction was vital for ship planning."
      ),
      keyMetricsToAsk = List(
        "Peak overland rail carloads per day arriving at Atlantic Ports of Embarkation in late 1943.",
        "Standard density ratio (cubic feet per measurement ton) for ship planning.",
        "Average turnaround time (days) of a freight car in the US overland pipeline in 1943."
      )
    ),
    Chapter(
      id = 7,
      title = "Outline OVERLORD and the Invasion of Italy",
      filename = "07-Outline-OVERLORD-and-the-Invasion-of-Italy.md",
      eraContext = "While COSSAC (Chief of Staff to the Supreme Allied Commander) drafted the outline plan for Operation OVERLORD in London, the Allied forces in the Mediterranean launched invasions of the Italian mainland (Salerno/Operation AVALANCHE). This double commitment tested the limits of port clearance and shipping capacities.",
      analyticalFocus = "The Salerno landings suffered from extreme landing craft shortages due to the rigid prioritization of the BOLERO build-up. Additionally, the subsequent capture of the Port of Naples showed how vulnerable Allied division-level maneuvers were to port destruction, forcing reliance on beach discharge and temporary pipelines.",
      simulationFocus = "Port Throughput Capacity with Berth Occupancy Limits. Modeling maximum daily tonnage capacity of a port as a function of berths, discharge rates, and efficiency.",
      mathFormulaIdea = "P_{throughput} = B \\cdot R_{discharge} \\cdot 24 \\cdot E_{efficiency}",
      startingScalaInterface = """package Logistics.OverlordItaly

case class PortSpecs(berths: Int, dischargeRateTonsPerHour: Double, efficiency: Double)

object PortThroughputModel:
  def dailyCapacity(specs: PortSpecs): Double =
    specs.berths * specs.dischargeRateTonsPerHour * 24.0 * specs.efficiency""",
      strategicQuestions = List(
        "Why did the COSSAC staff believe that the three-division assault limit for OVERLORD was logistically mandatory, and who later insisted on expanding it?",
        "Analyze how the destruction of the Port of Naples by retreating German forces impacted the logistical support of the Fifth Army in Italy."
      ),
      keyMetricsToAsk = List(
        "Initial assault division size envisioned in the COSSAC outline plan for OVERLORD.",
        "Date of Salerno landings (D-Day for AVALANCHE).",
        "Number of combat-loaded vessels available for the Salerno landing."
      )
    ),
    Chapter(
      id = 8,
      title = "First Quebec Conference (QUADRANT)",
      filename = "08-First-Quebec-Conference-QUADRANT.md",
      eraContext = "At the QUADRANT Conference (August 1943), the Combined Chiefs of Staff formally approved the COSSAC plan for OVERLORD and established a concrete pipeline of resources. It also marked the creation of the Southeast Asia Command (SEAC) to reorganize the chaotic CBI theater.",
      analyticalFocus = "Modern logistical analysis of QUADRANT highlights the realization that direct invasion of France was impossible without artificial harbor systems (Mulberry harbors). This shifted massive manufacturing and engineering assets to the ETO pipeline, increasing the lead time delay of other theater supply requests.",
      simulationFocus = "Multi-Stage Logistical Pipeline Lead Time. Summing transit, manufacturing, and processing delays to project temporal delays on theater resource changes.",
      mathFormulaIdea = "L_{total} = T_{mfg} + T_{transit} + T_{processing}",
      startingScalaInterface = """package Logistics.Quadrant

opaque type Days = Int
object Days:
  def apply(value: Int): Days = value
  extension (d: Days) def toInt: Int = d

case class PipelineStages(mfg: Days, transit: Days, processing: Days)

object PipelineLeadTime:
  def totalLeadTime(stages: PipelineStages): Days =
    Days(stages.mfg.toInt + stages.transit.toInt + stages.processing.toInt)""",
      strategicQuestions = List(
        "How did the creation of SEAC aim to resolve the command conflicts between the British, the Americans (Stilwell), and the Chinese (Chiang Kai-shek)?",
        "What logistical challenges prompted the decision to build artificial 'Mulberry' harbors, and what resources were allocated to their construction?"
      ),
      keyMetricsToAsk = List(
        "Finalized OVERLORD target target date approved at QUADRANT.",
        "Number of artificial Mulberry harbors authorized for construction at QUADRANT.",
        "Allocated shipping tonnage (long tons) for the initial Southeast Asia Command (SEAC) supply baseline."
      )
    ),
    Chapter(
      id = 9,
      title = "Bog-Down in the Mediterranean",
      filename = "09-Bog-Down-in-the-Mediterranean.md",
      eraContext = "The Italian campaign slowed to a crawl during the winter of 1943-44. Planners encountered extreme weather, mountainous terrain, and destroyed infrastructure, which severely degraded supply movements. The bold end-run amphibious landing at Anzio (Operation SHINGLE) was launched to break the deadlock but quickly became logistically isolated.",
      analyticalFocus = "Anzio (SHINGLE) was a classic logistical 'straitjacket'. Planners did not allocate enough LSTs to sustain a rapid breakout. The beachhead was pinned down, and instead of a maneuver hub, it became a massive static sink for LST shuttle convoys from Naples, directly draining shipping assets from the vital BOLERO build-up in Southern England.",
      simulationFocus = "Mountain and Weather Road Transport Capacity degradation. Modeling truck convoy throughput over degraded mountain networks under adverse weather.",
      mathFormulaIdea = "C_{road} = N \\cdot \\frac{V \\cdot Payload}{Distance} \\cdot F_{degrad}",
      startingScalaInterface = """package Logistics.BogDown

case class TruckConvoy(truckCount: Int, averagePayloadTons: Double, distanceMiles: Double)

object RoadThroughputModel:
  def calculateDailyTonnage(
    convoy: TruckConvoy,
    speedMph: Double,
    degradationFactor: Double
  ): Double =
    val tripsPerDay = (speedMph * 12.0) / convoy.distanceMiles
    val potentialTons = convoy.truckCount * convoy.averagePayloadTons * tripsPerDay
    potentialTons * degradationFactor""",
      strategicQuestions = List(
        "Why did Operation SHINGLE fail to achieve its strategic objectives, and how did its logistical requirements drain resources from the preparations for OVERLORD?",
        "Describe the 'Naples-Anzio LST Shuttle' and how it represented an innovative use of amphibious shipping in a sustained support role."
      ),
      keyMetricsToAsk = List(
        "Launch date of Operation SHINGLE (Anzio landings).",
        "Width (miles) of the Anzio beachhead pocket during the stalemate.",
        "Required daily supply delivery (tons) to sustain the isolated Anzio force."
      )
    ),
    Chapter(
      id = 10,
      title = "Ships, Landing Craft, and Strategy",
      filename = "10-Ships-Landing-Craft-and-Strategy.md",
      eraContext = "This chapter serves as a deep dive into the supreme constraint of the European war: shipping and landing craft. It examines the competition for steel, shipyard capacities, and the impact of landing craft production on the global strategic timeline.",
      analyticalFocus = "Modern analysis indicates that landing craft production (specifically LSTs) competed directly with the Navy's Destroyer Escort (DE) program. The JCS and President Roosevelt frequently shifted shipyard steel priorities based on the immediacy of the U-boat threat vs. amphibious plans, resulting in a volatile, highly unpredictable supply of landing craft for planners.",
      simulationFocus = "Fleet Dynamics with Production and Operational Attrition. Modeling fleet pool projections over time under constant production and attrition rates.",
      mathFormulaIdea = "F_{t+1} = F_t + P_t - A_t \\cdot F_t",
      startingScalaInterface = """package Logistics.ShipsLandingCraft

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
      strategicQuestions = List(
        "Explain why the LST was considered the 'unanimous bottleneck' of World War II logistics.",
        "How did the division of steel between the Navy's combatant ship program and the Maritime Commission's merchant program affect overall strategy?"
      ),
      keyMetricsToAsk = List(
        "Total Liberty ships completed by US shipyards in the peak year of 1943.",
        "Global deficit in LST production compared to ETO planners' requirements in late 1943.",
        "Standard building duration (days) of an LST in a Kaiser shipyard in 1943."
      )
    ),
    Chapter(
      id = 11,
      title = "The Cairo-Tehran Conferences (SEXTANT/EUREKA)",
      filename = "11-The-Cairo-Tehran-Conferences.md",
      eraContext = "The SEXTANT (Cairo) and EUREKA (Tehran) conferences in late 1943 brought Roosevelt, Churchill, and Stalin together. Stalin’s firm demand for a primary cross-channel operation (OVERLORD) in mid-1944 forced the cancellation of planned Mediterranean amphibious operations and Operation BUCCANEER in the Bay of Bengal.",
      analyticalFocus = "The Tehran Conference was the ultimate arbiter of theater resource allocation. Stalin's insistence on a simultaneous major operation in Northern France (OVERLORD) and Southern France (ANVIL) meant that other operations, like BUCCANEER in Southeast Asia, had to surrender their landing craft and troop transport ships. This solidified the 'Europe First' strategic resource split.",
      simulationFocus = "Multi-Objective Coalition Resource Division. Selecting and filtering theater objectives based on total available global resources.",
      mathFormulaIdea = "U_{allied} = \\sum_{i} A_i \\cdot V_i",
      startingScalaInterface = """package Logistics.CairoTehran

case class TheaterObjective(name: String, alignmentScore: Double, resourceRequired: Double)

object CoalitionResourceSplit:
  def evaluateAllocations(
    objectives: List[TheaterObjective],
    availableResources: Double
  ): List[TheaterObjective] =
    objectives.filter(_.resourceRequired <= availableResources)""",
      strategicQuestions = List(
        "Why did Stalin’s presence at Tehran fundamentally alter the balance of power between the US and British strategic concepts?",
        "Explain the logistical and strategic implications of canceling Operation BUCCANEER."
      ),
      keyMetricsToAsk = List(
        "Soviet combat division size committed to Operation Bagration to support OVERLORD.",
        "Number of landing craft released back to the European pool due to the cancellation of BUCCANEER."
      )
    ),
    Chapter(
      id = 12,
      title = "Inventory and Aftermath",
      filename = "12-Inventory-and-Aftermath.md",
      eraContext = "This chapter reviews the logistical balance sheet at the end of 1943. Planners assessed shipping losses, depot stocks in England, and port preparations to confirm whether the massive pipeline from the United States could support the scheduled 1944 offensives.",
      analyticalFocus = "Despite shipping millions of tons of cargo, ETO depots suffered from severe selective deficits. While some categories (like ammunition) were overstocked, critical 'Category II' items like tactical trucks, trailers, and specialized communications gear were in short supply due to shipping planners prioritizing raw weight over volumetric assembly components.",
      simulationFocus = "Depot Inventory Balance and Deficit Modeling. Calculating the deviation ratio of actual stocks against authorized inventory targets across multiple categories.",
      mathFormulaIdea = "Imbalance_i = \\frac{S_{actual} - S_{auth}}{S_{auth}}",
      startingScalaInterface = """package Logistics.InventoryAftermath

case class StockItem(name: String, actual: Double, authorized: Double)

object InventoryBalanceModel:
  def computeImbalances(items: List[StockItem]): List[(String, Double)] =
    items.map { item =>
      val ratio = (item.actual - item.authorized) / item.authorized
      item.name -> ratio
    }""",
      strategicQuestions = List(
        "What were the main causes of the 'imbalance' in UK depots at the end of 1943?",
        "How did the reduction in Atlantic shipping losses in late 1943 affect the logistical outlook for OVERLORD?"
      ),
      keyMetricsToAsk = List(
        "Total US Army cargo (long tons) shipped to the United Kingdom for BOLERO by December 1943.",
        "Percentage deficit of critical Category II tactical vehicles in ETO depots in late 1943.",
        "Merchant vessel loss rate (percentage) in North Atlantic convoys in the last quarter of 1943."
      )
    ),
    Chapter(
      id = 13,
      title = "OVERLORD and ANVIL",
      filename = "13-OVERLORD-and-ANVIL.md",
      eraContext = "The conflict between the cross-channel invasion (OVERLORD) and the landing in Southern France (ANVIL) dominated Allied planning in early 1944. Planners debated whether ANVIL was a necessary diversion to secure French ports (Marseille) or a dangerous division of scarce landing craft.",
      analyticalFocus = "Eisenhower argued that ANVIL was essential to capture Marseille, the only deepwater port capable of opening a third major supply pipeline into Europe. Montgomery, however, demanded an expanded OVERLORD landing force (from 3 to 5 divisions), which required absorbing ANVIL's landing craft and postponing the Southern France invasion. This created a complex operational scheduling conflict.",
      simulationFocus = "Critical Path Method (CPM) Project Scheduling. Projecting start dates and duration vectors under joint resource constraints.",
      mathFormulaIdea = "ES_j = \\max_{i \\in Pred(j)} \\{ EF_i \\}",
      startingScalaInterface = """package Logistics.OverlordAnvil

case class Task(name: String, durationDays: Int, predecessors: List[String])

object ProjectScheduler:
  def calculateSimpleSchedule(tasks: List[Task]): Map[String, Int] =
    tasks.foldLeft(Map[String, Int]()) { (acc, task) =>
      val es = task.predecessors.flatMap(p => acc.get(p).map(_ + tasks.find(_.name == p).map(_.durationDays).getOrElse(0))).maxOption.getOrElse(0)
      acc + (task.name -> es)
    }""",
      strategicQuestions = List(
        "Why did General Eisenhower view the ANVIL operation as logistically essential for the long-term support of the Allied drive into Germany?",
        "Analyze the strategic debate between the British (who favored exploiting the Italian campaign or the Balkans) and the Americans (who stood firm on ANVIL)."
      ),
      keyMetricsToAsk = List(
        "Invasion division size increase demanded by Montgomery and Eisenhower in early 1944.",
        "Postponement duration (months/days) of Operation ANVIL relative to D-Day.",
        "Capacity (tons/day) of the Port of Marseille once cleared by Allied engineers."
      )
    ),
    Chapter(
      id = 14,
      title = "The OVERLORD-ANVIL Build-Up",
      filename = "14-The-OVERLORD-ANVIL-Build-Up.md",
      eraContext = "In the months preceding D-Day, the United Kingdom became a packed logistical platform. This chapter describes the final, massive movement of troops and supplies to Southern England ports, the waterproofing of thousands of vehicles, and the organization of the pre-planned 'push' supply system.",
      analyticalFocus = "The pre-D-Day build-up required a shift from a 'pull' requisition system to a 'push' system. In the initial assault phase, troops could not stop to submit requisitions; instead, predetermined supply blocks (packages of ammo, fuel, and rations) were pushed forward automatically based on expected consumption models. This required intensive preprocessing, camp concentration, and waterproofing lines.",
      simulationFocus = "Processing Capacity and Vehicle Staging. Calculating processing limits of waterproofing lines under daily hour and line constraints.",
      mathFormulaIdea = "T_{waterproof} = N_{lines} \\cdot R_{rate} \\cdot H_{hours}",
      startingScalaInterface = """package Logistics.BuildUp

case class WaterproofingStation(lines: Int, ratePerLinePerHour: Double)

object StoragePacking:
  def maxWaterproofCapacity(station: WaterproofingStation, dailyHours: Double): Int =
    (station.lines * station.ratePerLinePerHour * dailyHours).toInt""",
      strategicQuestions = List(
        "What is the difference between a 'push' supply system and a 'pull' supply system, and why was the former mandatory for the initial D-Day landings?",
        "How did the 'Marshalling Areas' in Southern England function to maintain tactical organization while handling massive logistical throughput?"
      ),
      keyMetricsToAsk = List(
        "Total US troop strength (millions) in the UK by June 1944.",
        "Number of distinct vehicle classes requiring specialized waterproofing kits.",
        "Assault phase 'push' supply pipeline duration (days) before transitioning to 'pull'."
      )
    ),
    Chapter(
      id = 15,
      title = "The Aftermath of OVERLORD",
      filename = "15-The-Aftermath-of-OVERLORD.md",
      eraContext = "Following the successful landings on June 6, 1944, the Allies faced the critical task of sustaining the breakout. Planners wrestled with the destruction of the Mulberry harbor at Omaha beach by a severe storm, the slow capture of Cherbourg, and the creation of the famous 'Red Ball Express' truck convoy system to chase the rapid breakout.",
      analyticalFocus = "Modern logistics scholarship reveals that the rapid breakout of the Third Army (Patton) outran its supply depots, creating the first 'terminal distribution crisis'. The Red Ball Express, while famous, was highly inefficient; truck convoys consumed up to 30% of their own fuel payload in transit, and the lack of rail clearance at the front caused massive packaging damage and depot backlogs.",
      simulationFocus = "Closed-Loop Express Highway Network Flow. Calculating maximum daily tonnage delivered as a function of fleet size, payload, round-trip transit times, and terminal loading delays.",
      mathFormulaIdea = "T_{max} = \\frac{N \\cdot P_{payload}}{2 \\cdot (D / V + T_{load})}",
      startingScalaInterface = """package Logistics.OverlordAftermath

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
    if roundTripTimeHours <= 0.0 then 0.0
    else
      val tripsPerDay = 24.0 / roundTripTimeHours
      config.trucks * config.payloadTons * tripsPerDay""",
      strategicQuestions = List(
        "How did the loss of the Omaha Mulberry harbor alter the planned Allied supply schedule, and what alternative methods proved surprisingly successful?",
        "Analyze the logistical cost of the rapid breakout (pursuit) across France, focusing on the point where the consumption of fuel by supply trucks exceeded the delivery to combat units."
      ),
      keyMetricsToAsk = List(
        "Date of the severe channel storm that destroyed the Omaha Mulberry harbor.",
        "Peak number of operational trucks committed to the Red Ball Express.",
        "Daily fuel requirements (gallons) of a pursuit division in late August 1944."
      )
    ),
    Chapter(
      id = 16,
      title = "Pacific Strategy and Its Material Bases",
      filename = "16-Pacific-Strategy-and-Its-Material-Bases.md",
      eraContext = "Logistics in the Pacific War was fundamentally different from the European Theater. Distances were vast, landbases were scarce, and joint Army-Navy cooperation was mandatory. This chapter analyzes the physical geography and shipping networks that formed the basis of Pacific strategy.",
      analyticalFocus = "In the Pacific, the tyranny of distance meant that shipping transit times were up to three times longer than in the Atlantic, multiplying the ship-to-division requirement. Planners had to construct entire base networks on primitive coral atolls, meaning that every invasion force had to carry its own ports, roads, water filtration, and storage depots.",
      simulationFocus = "Exponential Distance Decay of Supply Throughput. Modeling effective supply delivery as an exponential decay function of transit distance and route loss.",
      mathFormulaIdea = "S_{eff} = S_0 \\cdot e^{-\\lambda \\cdot D}",
      startingScalaInterface = """package Logistics.PacificStrategy

import scala.math.exp

object PacificSupplyLossModel:
  def effectiveThroughput(
    initialTonnage: Double,
    distanceMiles: Double,
    decayRate: Double
  ): Double =
    if distanceMiles < 0.0 || decayRate < 0.0 then initialTonnage
    else initialTonnage * exp(-decayRate * distanceMiles)""",
      strategicQuestions = List(
        "Explain the logistical concept of 'island hopping' and how it minimized the shipping tonnage required to advance the strategic front.",
        "How did the geographic vastness of the Pacific impact the 'turnaround time' of merchant shipping compared to the North Atlantic route?"
      ),
      keyMetricsToAsk = List(
        "Shipping lane distance (nautical miles) from San Francisco to Brisbane, Australia.",
        "Tonnage multiplier (Pacific vs. Europe) required to sustain a soldier due to local infrastructure deficits.",
        "Standard round-trip voyage duration (days) for a Liberty ship on the San Francisco-Noumea run."
      )
    ),
    Chapter(
      id = 17,
      title = "Joint Logistics in Pacific Operations: The Continental System",
      filename = "17-Joint-Logistics-in-Pacific-Operations-The-Continental-System.md",
      eraContext = "Managing the dual demands of the Army and Navy in the Pacific required setting up unified logistical boards. This chapter explores the 'Continental System' developed on the US West Coast to coordinate procurement, storage, and port facilities for both services.",
      analyticalFocus = "The West Coast Ports of Embarkation (especially San Francisco and Seattle) experienced intense bottleneck friction as the Army and Navy scrambled to load cargo. Without the 'Continental System'—which established joint holding yards and holding & reconsignment depots in the interior—trains would have clogged West Coast yards, paralyzing the Pacific pipeline.",
      simulationFocus = "Shared Resource Queue Delay (M/M/1 model). Estimating queueing delay at ports of embarkation where arrival and service rates determine system saturation.",
      mathFormulaIdea = "W = \\frac{1}{\\mu - \\lambda}",
      startingScalaInterface = """package Logistics.ContinentalSystem

case class PortQueue(arrivalRatePerDay: Double, serviceRatePerDay: Double)

object QueueingModel:
  def averageDelayDays(queue: PortQueue): Double =
    if queue.serviceRatePerDay > queue.arrivalRatePerDay then
      1.0 / (queue.serviceRatePerDay - queue.arrivalRatePerDay)
    else
      Double.PositiveInfinity""",
      strategicQuestions = List(
        "What were the main sources of friction between the Army Service Forces and the Navy's Bureau of Supplies and Accounts during the establishment of the West Coast joint ports?",
        "How did the 'Continental System' prevent the duplication of storage depots in California?"
      ),
      keyMetricsToAsk = List(
        "Establishment date of the Joint Army-Navy Logistics Board (JANET).",
        "Peak monthly measurement tons of cargo cleared through San Francisco Port of Embarkation in late 1944."
      )
    ),
    Chapter(
      id = 18,
      title = "Joint Logistics in the Pacific Theaters",
      filename = "18-Joint-Logistics-in-the-Pacific-Theaters.md",
      eraContext = "This chapter moves into the actual theater of operations, analyzing how General Douglas MacArthur’s Southwest Pacific Area (SWPA) and Admiral Chester Nimitz’s Pacific Ocean Areas (POA) managed supply lines. It covers the creation of the Service Force, Pacific Fleet (ServPac) and regional base networks.",
      analyticalFocus = "The SWPA and POA operated under fundamentally different logistical philosophies. Nimitz’s POA relied on the Navy’s 'mobile service bases' (ServPac), which used floating depots (concrete barges, repair ships, and tankers) that moved with the fleet. MacArthur's SWPA relied on fixed landbases carved out of the New Guinea jungle, which required massive construction engineering forces and land-clearing equipment.",
      simulationFocus = "Decentralized Logistics Network Multi-Hub Distribution Cost. Calculating distribution costs as a function of transit volumes and distances across multiple routes.",
      mathFormulaIdea = "C_{dist} = \\sum_{i} V_i \\cdot D_i",
      startingScalaInterface = """package Logistics.PacificTheaters

case class SupplyRoute(volumeTons: Double, distanceMiles: Double)

object DecentralizedLogisticsNetwork:
  def totalDistributionCost(routes: List[SupplyRoute]): Double =
    routes.map(r => r.volumeTons * r.distanceMiles).sum""",
      strategicQuestions = List(
        "Contrast the Navy's 'mobile base' concept (ServPac) with the Army's 'fixed land base' concept in the Pacific. What were the logistical advantages of each?",
        "How did the division of the Pacific into SWPA and POA lead to competing demands for shipping, and how was this conflict managed?"
      ),
      keyMetricsToAsk = List(
        "Name of the SWPA Services of Supply commander.",
        "Total number of auxiliary vessels and floating concrete barges in ServPac's mobile bases in late 1944.",
        "Average distance (miles) from MacArthur's primary supply base at Hollandia to the Leyte invasion beaches."
      )
    ),
    Chapter(
      id = 19,
      title = "Shipping in the Pacific War",
      filename = "19-Shipping-in-the-Pacific-War.md",
      eraContext = "Shipping was the lifeblood of the Pacific campaigns. Because voyages were incredibly long, ships spent a high percentage of their time in transit or waiting to discharge cargo at primitive island anchorages, leading to the 'retention' of precious hulls in theater.",
      analyticalFocus = "The 'retention' of ships as floating warehouses was a major global crisis. Theater commanders, fearful of being cut off, refused to discharge and return merchant ships to the US West Coast. In late 1944, hundreds of Liberty ships sat idle in Pacific ports for months, creating an artificial global shipping shortage that directly delayed operations in Europe.",
      simulationFocus = "Floating Storage Turnaround and Fleet Size Calculations. Estimating the total hulls needed to sustain a target daily tonnage under heavy turnaround delay penalties.",
      mathFormulaIdea = "N = \\frac{D_{target} \\cdot T_{cycle}}{C}",
      startingScalaInterface = """package Logistics.PacificShipping

case class FleetTarget(dailyTonsTarget: Double, shipCapacityTons: Double)

object FleetSustenanceModel:
  def requiredHulls(target: FleetTarget, turnaroundDays: Double): Int =
    if target.shipCapacityTons <= 0.0 || turnaroundDays <= 0.0 then 0
    else
      val dailyShipsNeeded = target.dailyTonsTarget / target.shipCapacityTons
      Math.ceil(dailyShipsNeeded * turnaroundDays).toInt""",
      strategicQuestions = List(
        "Explain the phenomenon of 'floating storage' in the Pacific. Why did theater commanders refuse to release cargo ships, and how did this impact global Allied strategy?",
        "What measures did the War Shipping Administration (WSA) take to reduce turnaround times in Pacific ports?"
      ),
      keyMetricsToAsk = List(
        "Average round-trip turnaround time (days) for a cargo vessel from the US West Coast to the SWPA in 1944.",
        "Average number of merchant vessels 'retained' in theater as floating storage in mid-1944.",
        "Daily cost (dollars) or capacity loss associated with holding a Liberty ship idle in a forward anchor pool."
      )
    ),
    Chapter(
      id = 20,
      title = "Supplying the Army in Pacific Theaters",
      filename = "20-Supplying-the-Army-in-Pacific-Theaters.md",
      eraContext = "This chapter details the specific tactical supply problems encountered by the Army in tropical climates: food spoilage, mold, mildew, rust, and the physical breakdown of packaging. It highlights the development of specialized 'jungle rations' and waterproofing techniques.",
      analyticalFocus = "Tropical logistics forced a redesign of material science. High humidity and fungal growth destroyed standard paperboard packaging, leading to the development of asphalt-laminated carton liners and dipped wax coatings. Without these innovations, over half of all ammunition and rations shipped to the South Pacific arrived in an unusable state.",
      simulationFocus = "Tropical Material Spoilage and Stock Decay over Time. Modeling stock depletion due to decay curves in hot, humid environments.",
      mathFormulaIdea = "S_t = S_0 \\cdot e^{-\\alpha \\cdot t}",
      startingScalaInterface = """package Logistics.SupplyingPacific

import scala.math.exp

case class SupplyStock(initialTons: Double, decayRate: Double)

object SpoilageDepreciationModel:
  def remainingStock(stock: SupplyStock, months: Double): Double =
    if months < 0.0 || stock.decayRate < 0.0 then stock.initialTons
    else stock.initialTons * exp(-stock.decayRate * months)""",
      strategicQuestions = List(
        "How did the lack of refrigerated storage (reefer ships and warehouses) limit the diet and morale of troops in the Southwest Pacific?",
        "What innovations in packaging (such as laminated foils and dipping waxes) were developed to protect ammunition and medical supplies from moisture?"
      ),
      keyMetricsToAsk = List(
        "Estimated percentage loss of stored dry rations due to tropical rot within 3 months of storage.",
        "Average weight loss (lbs/man) of soldiers operating on prolonged Type C/K ration diets.",
        "Average relative humidity percentage of the New Guinea jungle depots."
      )
    ),
    Chapter(
      id = 21,
      title = "China, Burma, and India",
      filename = "21-China-Burma-and-India.md",
      eraContext = "The China-Burma-India (CBI) theater was a logistical nightmare. Following the Japanese closure of the Burma Road, the only link to China was 'The Hump' airlift over the Himalayas. This chapter examines the extreme trade-offs between flying cargo to China versus building the overland Ledo Road.",
      analyticalFocus = "The CBI theater was a classic case of low-efficiency, high-political-priority logistics. Flying supplies over 'The Hump' was mathematically brutal: transport planes had to carry their own fuel for the return flight, meaning that on longer runs, up to 4 tons of aviation fuel were burned for every 1 ton of cargo delivered to Kunming. Build-up of local infrastructure was incredibly slow.",
      simulationFocus = "Airlift Payload-to-Fuel Consumption Ratio and Net Cargo Yield. Calculating the net cargo capacity delivered after subtracting transit fuel burn.",
      mathFormulaIdea = "C_{net} = C_{max} - F_{burn} \\cdot T_{flight}",
      startingScalaInterface = """package Logistics.CBI

case class AircraftSpecs(maxPayloadLbs: Double, fuelBurnLbsPerHour: Double)

object AirliftEfficiencyModel:
  def netCargoDelivered(
    specs: AircraftSpecs,
    flightDurationHours: Double,
    roundTrip: Boolean
  ): Double =
    val multiplier = if roundTrip then 2.0 else 1.0
    val transitFuel = specs.fuelBurnLbsPerHour * flightDurationHours * multiplier
    val net = specs.maxPayloadLbs - transitFuel
    if net < 0.0 then 0.0 else net""",
      strategicQuestions = List(
        "Explain the 'Hump Paradox': Why was the airlift considered an inefficient use of resources, and why did General Marshall continue to support it?",
        "Describe Stilwell's strategic vision for the Ledo Road and how it conflicted with Chennault's air-centric strategy for China."
      ),
      keyMetricsToAsk = List(
        "Peak monthly tonnage delivered over 'The Hump' by the ATC in late 1944.",
        "Aviation fuel transit consumption ratio (tons burned per ton delivered) for Hump transport flights.",
        "Total length (miles) of the Ledo (Stilwell) Road from Assam to Kunming."
      )
    ),
    Chapter(
      id = 22,
      title = "Stresses and Strains of a Two-Front War",
      filename = "22-Stresses-and-Strains-of-a-Two-Front-War.md",
      eraContext = "By mid-1944, the US was waging full-scale offensives in both Europe and the Pacific. This chapter examines the global competition for resources (such as artillery ammunition, heavy trucks, and engineering equipment) that strained the US industrial base to its absolute limits.",
      analyticalFocus = "In mid-1944, the US industrial engine hit a rigid capacity ceiling. Planners had to deal with zero-sum trade-offs: every heavy truck sent to the Pacific was one fewer truck available to clear the railheads in France. The JCS had to continuously adjust priority parameters, resulting in systemic delays across both major pipelines.",
      simulationFocus = "Linear Global Resource Split Optimization. Partitioning a single production output between two competing theater demand nodes based on strategic weights.",
      mathFormulaIdea = "X_{ETO} + X_{PAC} \\le P_{total}",
      startingScalaInterface = """package Logistics.TwoFrontWar

case class ProductionLimits(totalOutput: Double)

object DualFrontOptimizer:
  def optimalSplit(
    limits: ProductionLimits,
    etoWeight: Double,
    pacWeight: Double
  ): (Double, Double) =
    val sum = etoWeight + pacWeight
    if sum <= 0.0 then (0.0, 0.0)
    else
      val etoAlloc = (etoWeight / sum) * limits.totalOutput
      val pacAlloc = (pacWeight / sum) * limits.totalOutput
      (etoAlloc, pacAlloc)""",
      strategicQuestions = List(
        "Why did the Allied planners underestimate the requirement for artillery ammunition in Europe, and what measures were taken in late 1944 to increase production?",
        "How did the JCS handle the competing demands for heavy engineering equipment (such as bulldozers) between the Pacific base developers and the European reconstruction teams?"
      ),
      keyMetricsToAsk = List(
        "Late 1944 monthly demand for 105mm artillery ammunition in Europe vs. actual US monthly production capacity.",
        "Global deficit of heavy tactical trucks (4-to-10 ton class) in late 1944.",
        "Percentage of US heavy machinery production allocated directly to military construction units in 1944."
      )
    ),
    Chapter(
      id = 23,
      title = "The Pacific in Transition",
      filename = "23-The-Pacific-in-Transition.md",
      eraContext = "In late 1944, the Pacific campaigns accelerated with the invasion of the Philippines (Leyte and Luzon). This chapter covers the massive logistical shift as bases were moved forward from New Guinea and the Marianas to support the re-entry into the Philippines.",
      analyticalFocus = "Moving the logistical 'center of gravity' forward in the Pacific was an incredibly complex transition. Setting up base networks on Leyte during the monsoon season paralyzed overland movement. Planners had to construct airfields and depots on mud, forcing reliance on offshore floating storage and shipping pipelines to keep troops sustained.",
      simulationFocus = "Base Relocation Staging Transit Cost and Delay Vector. Modeling relocation overhead as a function of cargo volume, distance, and base setup time.",
      mathFormulaIdea = "C_{reloc} = V \\cdot (D \\cdot T_{transit} + S)",
      startingScalaInterface = """package Logistics.PacificTransition

case class BaseSpecs(cargoVolumeTons: Double, setupDays: Double)

object BaseRelocationModel:
  def relocationCost(
    specs: BaseSpecs,
    distanceMiles: Double,
    transitTimePerMileDay: Double
  ): Double =
    if distanceMiles < 0.0 || transitTimePerMileDay < 0.0 then specs.cargoVolumeTons * specs.setupDays
    else specs.cargoVolumeTons * (distanceMiles * transitTimePerMileDay + specs.setupDays)""",
      strategicQuestions = List(
        "Describe the logistical challenges of setting up major supply bases on Leyte during the monsoon season.",
        "How did the capture of the Marianas (Saipan, Tinian, Guam) alter the logistical support of the strategic B-29 bombing campaign against Japan?"
      ),
      keyMetricsToAsk = List(
        "Launch date of the Leyte invasion (Operation KING II).",
        "Assault troop strength and cargo tonnage carried to Leyte in the initial wave.",
        "Target quantity (measurement tons) of base construction materials required for the Leyte build-up."
      )
    ),
    Chapter(
      id = 24,
      title = "Logistics of a One-Front War",
      filename = "24-Logistics-of-a-One-Front-War.md",
      eraContext = "As the defeat of Germany became imminent in early 1945, planners shifted their focus to a 'One-Front War' model. This required planning for 'Redirection' (diverting ETO-bound supply ships directly to the Pacific) and the massive redeployment of millions of troops from Europe to the Pacific (Operation Redeployment).",
      analyticalFocus = "Rerouting the massive Allied supply pipeline from the Atlantic to the Pacific was a monumental scheduling task. Ships had to be redirected in transit via the Panama Canal, causing severe cargo balance problems because ships loaded for the ETO did not match the base construction and tropical requirements of the Pacific theaters.",
      simulationFocus = "Route Redirection Distance and Transit Time Penalty Vector. Calculating route-redirection distance changes when rerouting cargo.",
      mathFormulaIdea = "D_{extra} = D_{new} - D_{old}",
      startingScalaInterface = """package Logistics.OneFrontWar

case class RouteDistances(usToEurope: Double, usToPacific: Double)

object RouteRedirectionModel:
  def extraDistanceMiles(routes: RouteDistances): Double =
    routes.usToPacific - routes.usToEurope""",
      strategicQuestions = List(
        "Why did the 'Redirection' of cargo ships in mid-1945 prove to be one of the most complex scheduling tasks ever attempted by the War Shipping Administration?",
        "What were the psychological and physical impacts on ETO veteran troops scheduled for immediate redeployment to the Pacific?"
      ),
      keyMetricsToAsk = List(
        "Target ETO troop strength (millions) scheduled for redeployment to the Pacific post V-E Day.",
        "Number of cargo vessels redirected mid-voyage or mid-loading in early-to-mid 1945.",
        "Average transit time difference (days) from ETO ports to SWPA compared to Atlantic routing."
      )
    ),
    Chapter(
      id = 25,
      title = "Lend-Lease and the Common Pool",
      filename = "25-Lend-Lease-and-the-Common-Pool.md",
      eraContext = "Lend-Lease was not a one-way street but a 'Common Pool' of resources. This chapter explores the financial and physical mechanics of Lend-Lease, focusing on the pooling of merchant shipping (the 'shipping pool') and 'Reverse Lend-Lease' (reciprocal aid provided by the British and other allies to US forces).",
      analyticalFocus = "The 'Common Pool' was an early form of linear program optimization. Rather than tracking individual national purchases, Allied shipping was pooled globally under the Combined Shipping Adjustment Board (CSAB). This allowed ships to be dispatched dynamically to whichever theater had the most critical deficit, maximizing overall global Allied supply throughput.",
      simulationFocus = "Bilateral Resource Exchange Matrix and Net Tonnage Balance. Estimating the net exchange balance for a country across multiple trade flows.",
      mathFormulaIdea = "B_i = \\sum_{j} L_{ij} - \\sum_{j} L_{ji}",
      startingScalaInterface = """package Logistics.LendLease

case class TradeFlow(source: String, destination: String, valueBillions: Double)

object ReverseLendLeaseMatrix:
  def netBalance(country: String, flows: List[TradeFlow]): Double =
    val outFlow = flows.filter(_.source == country).map(_.valueBillions).sum
    val inFlow = flows.filter(_.destination == country).map(_.valueBillions).sum
    outFlow - inFlow""",
      strategicQuestions = List(
        "How did the concept of the 'Common Pool' challenge traditional ideas of national sovereignty and military procurement?",
        "Detail the strategic value of 'Reverse Lend-Lease' in minimizing the shipping tonnage the US had to send to England and Australia."
      ),
      keyMetricsToAsk = List(
        "Total dollar value of US Lend-Lease aid provided by the end of 1944.",
        "Total dollar value of Reverse Lend-Lease provided to the US by the United Kingdom.",
        "Percentage of British food and fuel requirements met via Lend-Lease imports."
      )
    ),
    Chapter(
      id = 26,
      title = "The End of the Common Pool",
      filename = "26-The-End-of-the-Common-Pool.md",
      eraContext = "This chapter covers the political and logistical wind-down of Lend-Lease in 1945. Following the surrender of Germany, the US rapidly reduced Lend-Lease deliveries to European allies, leading to severe diplomatic tension as nations struggled with reconstruction.",
      analyticalFocus = "The sudden cancellation of Lend-Lease after V-J Day triggered a severe logistical shock. Ships loaded with relief supplies were recalled or halted at ports of embarkation, creating massive cargo backlogs on East Coast docks and leaving Allied economies (particularly the UK) in an immediate balance-of-payments crisis.",
      simulationFocus = "Post-War Pool Drawdown Exponential Decay. Modeling the rapid reduction of supply deliveries over time post V-E/V-J Day.",
      mathFormulaIdea = "D_t = D_{peak} \\cdot e^{-k \\cdot (t - t_{VE})}",
      startingScalaInterface = """package Logistics.EndCommonPool

import scala.math.exp

case class DrawdownParameters(peakDelivery: Double, decayRate: Double)

object DrawdownCurve:
  def deliveryAtTime(params: DrawdownParameters, monthsPostVE: Double): Double =
    if monthsPostVE >= 0 then
      params.peakDelivery * exp(-params.decayRate * monthsPostVE)
    else
      params.peakDelivery""",
      strategicQuestions = List(
        "Why did the sudden termination of Lend-Lease surprise the British government, and what were the immediate economic consequences for the UK?",
        "How was the transition of shipping from the global pool back to private national fleets managed in late 1945?"
      ),
      keyMetricsToAsk = List(
        "Executive Order date of Lend-Lease termination signed by Truman.",
        "Tons of cargo left stranded on US docks originally destined for Great Britain upon cutoff."
      )
    ),
    Chapter(
      id = 27,
      title = "Aid to the USSR in the Later War Years",
      filename = "27-Aid-to-the-USSR-in-the-Later-War-Years.md",
      eraContext = "Sustaining the Soviet war effort required massive deliveries of raw materials, vehicles, and industrial machinery. This chapter analyzes the three main routes: the Arctic Convoys (Murmansk/Archangel), the Persian Corridor, and the Soviet-flagged Pacific Route (West Coast to Vladivostok).",
      analyticalFocus = "Modern analysis highlights that the Persian Corridor and Soviet-flagged Pacific Route were far more logistically significant than the highly publicized Arctic Convoys. While the Arctic route was fast, its attrition rate peaked at 20%. The Persian Corridor, though slower, was 100% secure, and the Pacific route (which relied on Soviet-flagged ships because Russia was not at war with Japan until August 1945) delivered over 50% of all Soviet Lend-Lease cargo.",
      simulationFocus = "Risk-Weighted Route Delivery and Net Expected Tonnage. Comparing multi-route shipping lanes under different loss rate profiles.",
      mathFormulaIdea = "C_{delivered} = C_{initial} \\cdot (1 - L_{rate})",
      startingScalaInterface = """package Logistics.SovietAid

case class RouteSpecs(name: String, lossRate: Double, transitDays: Double)

object SovietRouteRiskModel:
  def expectedDelivery(initialTons: Double, specs: RouteSpecs): Double =
    if specs.lossRate < 0.0 then initialTons
    else if specs.lossRate >= 1.0 then 0.0
    else initialTons * (1.0 - specs.lossRate)""",
      strategicQuestions = List(
        "Compare the strategic advantages and physical constraints of the Persian Corridor against the Arctic Route.",
        "How did the US-supplied locomotives and rolling stock revolutionize Soviet military rail transport during 1944-45?"
      ),
      keyMetricsToAsk = List(
        "Peak monthly tonnage cleared through the Persian Corridor by the Persian Gulf Command.",
        "Total number of US-supplied tactical trucks and jeeps delivered to the USSR by 1945.",
        "Attrition rate (percentage) of Allied cargo ships on the Arctic Route during the peak crisis period of 1942-43."
      )
    ),
    Chapter(
      id = 28,
      title = "Military Supply to Liberated and Latin American Nations",
      filename = "28-Military-Supply-to-Liberated-and-Latin-American-Nations.md",
      eraContext = "This chapter explores the logistics of re-arming Allied nations: equipping French divisions in North Africa, supporting Italian co-belligerent forces, and providing military assistance to Latin American countries. It examines the challenge of standardization when introducing US equipment to foreign forces.",
      analyticalFocus = "Re-arming foreign divisions presented severe standardization challenges. French forces, while eager, had completely different division-level structures and weapon calibers, requiring an extensive conversion of their maintenance pipelines to standard US calibers. This process highlighted that ammunition compatibility was more vital than nominal divisional counts.",
      simulationFocus = "Weapon System Standardization Compatibility Matcher. Checking compatibility between troop equipment calibers and standard logistics pipeline calibers.",
      mathFormulaIdea = "C = \\begin{cases} 1 & \\text{if } Caliber_{force} = Caliber_{pipeline} \\\\ 0 & \\text{otherwise} \\end{cases}",
      startingScalaInterface = """package Logistics.LiberatedNations

case class WeaponSystem(name: String, caliberMm: Double, countryOfOrigin: String)

object StandardizationMatcher:
  def isCompatible(system: WeaponSystem, pipelineCaliberMm: Double): Boolean =
    system.caliberMm == pipelineCaliberMm""",
      strategicQuestions = List(
        "What logistical issues arose from the French army's desire to maintain their traditional organizational structure while using American-made equipment?",
        "Analyze the strategic reasons behind providing military aid to Latin American nations during World War II."
      ),
      keyMetricsToAsk = List(
        "Number of French divisions re-armed and equipped with standard US materials.",
        "Total dollar value of Lend-Lease aid provided to Latin American nations during the war."
      )
    ),
    Chapter(
      id = 29,
      title = "Lend-Lease to China, 1943-45",
      filename = "29-Lend-Lease-to-China-1943-45.md",
      eraContext = "Following the opening of the Ledo Road (renamed the Stilwell Road) and the expansion of the pipeline, Lend-Lease to China increased. This chapter examines the physical movement of supplies from Calcutta ports, through Assam, and across the border to Chinese armies.",
      analyticalFocus = "The Stilwell Road was one of the most expensive logistical projects of the war. Modern analysis suggests its strategic utility was low: by the time the overland link was completed in early 1945, 'The Hump' airlift had expanded so much that it carried over 80% of China’s supply volume. The road consumed immense heavy engineering resources that could have been used to clear ports in Europe.",
      simulationFocus = "Convoy Throughput over Primitive Overland Roads. Calculating daily tonnage capacity of a primitive route under transit delays and dispatch intervals.",
      mathFormulaIdea = "T = \\frac{N \\cdot C}{\\delta + T_{transit}}",
      startingScalaInterface = """package Logistics.ChinaLendLease

case class ConvoyParameters(trucks: Int, avgPayloadTons: Double, transitDays: Double)

object RoadConvoyCapacity:
  def dailyCapacity(params: ConvoyParameters, dispatchIntervalDays: Double): Double =
    val totalTime = params.transitDays + dispatchIntervalDays
    if totalTime <= 0.0 then 0.0
    else (params.trucks * params.avgPayloadTons) / totalTime""",
      strategicQuestions = List(
        "Why did the opening of the Stilwell Road occur so late in the war, and did its strategic value justify the massive engineering effort?",
        "How did the Chinese currency inflation affect the local procurement of supplies by US Army units in China?"
      ),
      keyMetricsToAsk = List(
        "Arrival date of the first truck convoy over the Stilwell (Ledo) Road in Kunming, China.",
        "Total Lend-Lease tonnage delivered to China in 1944 vs. 1945.",
        "Daily fuel requirements (gallons) of Stilwell Road construction units in Burma."
      )
    ),
    Chapter(
      id = 30,
      title = "The Army and Civilian Supply: I",
      filename = "30-The-Army-and-Civilian-Supply-I.md",
      eraContext = "As Allied armies liberated territory in Europe, they immediately encountered starving populations, collapsed public utilities, and the threat of disease. This chapter examines the Army’s 'Civil Affairs' branch (G-5) and the logistics of distributing emergency food, coal, and medicine to liberated populations.",
      analyticalFocus = "Civilian relief was not just humanitarian; it was a military necessity to protect the lines of communication. The 'prevent disease and unrest' doctrine established that the Army had to secure a baseline of civilian survival (food and sanitation) because epidemics or riots in rear areas (like Naples or Paris) would immediately disrupt combat operations and drain forward logistics.",
      simulationFocus = "Civilian Population Caloric Relief Import demand forecasting. Calculating monthly food tonnage required based on population and target calories.",
      mathFormulaIdea = "T_{food} = \\frac{P \\cdot C \\cdot 30}{K_{calories/ton}}",
      startingScalaInterface = """package Logistics.CivilianSupplyI

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
    if caloriesPerTon <= 0.0 then 0.0
    else
      val dailyCaloricTotal = pop.toInt * caloricTarget
      val monthlyCaloricTotal = dailyCaloricTotal * 30.0
      monthlyCaloricTotal / caloriesPerTon""",
      strategicQuestions = List(
        "Why did the War Department accept responsibility for feeding civilian populations in combat zones? What was the 'prevent disease and unrest' doctrine?",
        "Detail the logistical difficulties of distributing coal to the French population during the freezing winter of 1944-45."
      ),
      keyMetricsToAsk = List(
        "Monthly wheat import requirement (tons) to feed Naples, Italy after liberation.",
        "Basic relief ration target (calories/person/day) established by G-5 in liberated Europe."
      )
    ),
    Chapter(
      id = 31,
      title = "The Army and Civilian Supply: II",
      filename = "31-The-Army-and-Civilian-Supply-II.md",
      eraContext = "This chapter expands on civilian supply, analyzing the complex logistics of relief in Asian and Pacific regions (including liberated Manila and Korea) and the transition of responsibility from the military to civilian organizations like the United Nations Relief and Rehabilitation Administration (UNRRA).",
      analyticalFocus = "The transition of relief from G-5 to UNRRA was a difficult hand-off. G-5 was organized to push supplies forcefully using military shipping and priority routing. UNRRA, as a civilian coalition, had to compete for scarce shipping with the military, which still prioritized the ongoing war in the Pacific. This led to severe distribution blockages in European ports.",
      simulationFocus = "Civilian Relief Distribution Queue modeling. Modeling average queue length at distribution stations using single-channel queue parameters.",
      mathFormulaIdea = "L_q = \\frac{\\lambda^2}{\\mu \\cdot (\\mu - \\lambda)}",
      startingScalaInterface = """package Logistics.CivilianSupplyII

case class DistributionStation(arrivalRatePerMin: Double, serviceRatePerMin: Double)

object ReliefDistributionQueue:
  def averageQueueLength(station: DistributionStation): Double =
    val l = station.arrivalRatePerMin
    val m = station.serviceRatePerMin
    if m > l then
      (l * l) / (m * (m - l))
    else
      Double.PositiveInfinity""",
      strategicQuestions = List(
        "What organizational differences made the transition from military G-5 supply to UNRRA control difficult?",
        "Compare the logistical challenges of civilian relief in a highly urbanized European setting with a devastated Pacific archipelago like the Philippines."
      ),
      keyMetricsToAsk = List(
        "Hand-over date of relief responsibility from the US Army to UNRRA in Europe.",
        "Emergency food tonnage distributed to Manila's population in the first month post-liberation."
      )
    ),
    Chapter(
      id = 32,
      title = "Logistics and Strategy in World War II",
      filename = "32-Logistics-and-Strategy-in-World-War-II.md",
      eraContext = "The concluding chapter synthesizes the grand lessons of World War II logistics. It reviews how logistics ceased to be a secondary service of support and became the primary determinant of grand strategy, dictating when, where, and with what force the Allied nations could strike.",
      analyticalFocus = "The ultimate conclusion of the Green Book series is that modern war is an industrial-logistical system. The Combined Chiefs of Staff could not execute a strategic maneuver until they had first compiled and verified its tonnage coefficients. Logistics was not merely the servant of strategy; it defined the outer boundaries of strategic feasibility.",
      simulationFocus = "Core Simulator Correlation Model (Logistics Throughput to Combat Index). Calculating the combat power index as a function of delivered tonnage, division count, and operational efficiency.",
      mathFormulaIdea = "P_{combat} = \\alpha \\cdot T_{theater} \\cdot N_{divisions}",
      startingScalaInterface = """package Logistics.Conclusion

case class TheaterState(tonnageDelivered: Double, divisionsInContact: Int)

object LogisticsCorrelationModel:
  def calculateCombatPowerIndex(
    state: TheaterState,
    efficiencyCoefficient: Double
  ): Double =
    if state.tonnageDelivered < 0.0 || state.divisionsInContact < 0 then 0.0
    else efficiencyCoefficient * state.tonnageDelivered * state.divisionsInContact.toDouble""",
      strategicQuestions = List(
        "In what ways did World War II redefine the relationship between a nation’s industrial capacity and its battlefield tactics?",
        "Assess the statement: 'Logistics is the science of military planning; strategy is merely the art of the possible.' How does the Green Book support this view?"
      ),
      keyMetricsToAsk = List(
        "Total overseas cargo tonnage (millions of long tons) shipped by the US Army during the war.",
        "Logistical operational expenditure percentage compared to total US war expenditure.",
        "Peak overseas troop strength (millions) of the US Army in 1945."
      )
    )
  )

  def main(args: Array[String]): Unit =
    val targetDir = Paths.get("prompts")
    if (!Files.exists(targetDir)) {
      Files.createDirectories(targetDir)
      println("Created prompts directory.")
    }

    chapters.foreach { ch =>
      val formattedId = s"${"%02d".format(ch.id)}"
      val v2Filename = s"${formattedId}-v2-${ch.filename.substring(3)}"
      
      val metricsBulletList = ch.keyMetricsToAsk.map(m => s"- $m").mkString("\n")

      // Using raw interpolator to preserve single backslashes in mathFormula
      val contentV2 = raw"""# Prompt for Chapter ${ch.id}: ${ch.title}

## Role and Task
You are a Principal Operations Research Analyst, a Military Logistics Historian, and a Senior Systems Architect specializing in WWII logistical pipelines.

Your task is to provide a highly detailed, professional-grade reference manual entry and simulation-specification document for **Chapter ${ch.id}: ${ch.title}** of the US Army Green Book *"Global Logistics and Strategy: 1943–1945"*. This document will be used to define the core database parameters, network topologies, capacity constraints, and state-transition logic for a high-fidelity, division-level WWII logistics simulator.

Do not write a generic summary or a high-school level study guide. Your response must be an intellectually rigorous and historically precise reference document.

---

## Required Response Structure and Content Guidelines

Your output must follow this exact structure, with no placeholder content:

### 1. Strategic Context & Modern Historical Perspective (Minimum 1000 words)
Provide a deep-dive, academic-level analysis of the strategic, political, and material tensions of this chapter. Incorporate modern historical perspectives and data available with the benefit of post-war declassifications and decades of logistical scholarship. Specifically address:
- **The Strategic Paradox:** How high-level Allied strategic plans (e.g., from conferences like Casablanca, TRIDENT, SEXTANT, QUADRANT) clashed with the physical limits of global shipping pools, combat loading capacities, and port clearance rates.
- **Inter-Service and Coalition Tensions:** Analyze command friction (such as the Services of Supply vs. Combat Commands, or Army vs. Navy, or US vs. British pooling arrangements).
- **Historical Era Context:**
  ${ch.eraContext}
- **Modern Analytical Insights:**
  ${ch.analyticalFocus}

### 2. High-Fidelity Simulation Parameters & Real-World Metrics
Generate a comprehensive, structured reference table containing all critical historical constants, coefficients, and operational metrics discussed in this chapter or uncovered by modern scholarship. These will serve as raw database values for our simulator. Specifically, find and include the exact values for:
${metricsBulletList}
For each metric, provide a detailed historical explanation and strategic rationale, explaining how it should be represented in a simulation state (e.g., as a static constant, dynamic capacity cap, or efficiency coefficient).

### 3. Logistical Network Topology (Detailed Mermaid.js Flowchart)
Design a highly detailed, production-grade Mermaid.js diagram showing the logistical network topology, depots, staging areas, ports, convoy routes, and combat nodes of this chapter. You must model capacity limits, congestion delays, and alternative routing:
- **Simulation Focus:** ${ch.simulationFocus}
- The diagram must represent the physical flow of supplies (e.g., tons of dry cargo, bulk petroleum, or ammunition) from POEs to final theater depots.

### 4. Mathematical Modeling & Simulation Formulas
Formulate the operational research equations representing the logistics bottleneck or resource allocation problem of this chapter.
- State the model using rigorous LaTeX mathematical formulation (use `$$$$` for block equations and `$$` for inline expressions).
- Define all constants, variables, objective functions, and constraints.
- Provide a detailed explanation of the formulas:
  $$$$\text{Mathematical Concept: } ${ch.mathFormulaIdea}$$$$

### 5. Compile-Safe Scala 3.8.3 Domain Model
Write a complete, highly-idiomatic, and production-ready Scala 3.8.3 domain model representing this mathematical system. This code will be directly integrated into our simulator's execution engine.
- **Strict Architecture Rules:**
  1. Use Scala 3's clean, curly-brace-free layout (indentation-based syntax).
  2. Use explicit type declarations for all public/protected methods and values.
  3. No wildcard imports; import symbols explicitly and group them at the top.
  4. Use strong, precise types: `opaque type` aliases for unit safety (e.g., NauticalMiles, Tons, Days), `enum` for state transitions, and sealed traits/case classes for domain ADTs.
  5. **Absolute Rule:** The code must compile perfectly and contain NO placeholders (`???`, `// TODO`, `...`, or commented-out sections). It must be fully implemented and correct.

Start with the following base and extend it into a comprehensive simulation module with additional parameters, state transitions, and validation checks:
```scala
${ch.startingScalaInterface}
```

### 6. Graduate-Level Operational Analysis
Provide long-form, intellectually challenging, and mathematically grounded answers to the following strategic discussion questions, referencing historical outcomes and physical logistics principles:
${ch.strategicQuestions.map(q => s"- $q").mkString("\n")}
"""

      val filePathV2 = targetDir.resolve(v2Filename)
      Files.write(filePathV2, contentV2.getBytes(StandardCharsets.UTF_8))
      println(s"Generated: $v2Filename")
    }
    println("All 32 chapter prompts (v2 reference prompts) have been successfully generated.")
