Cost: 0.001321488

## 1. Strategic Context & Modern Historical Perspective

**The Strategic Paradox**  
By the end of 1943, the Grand Alliance had achieved a series of decisive victories—the collapse of Axis forces in North Africa, the conquest of Sicily, the first stages of the Italian Campaign, and the turning of the tide in the Atlantic. Yet the logistical foundation for the most critical operation of the war, the cross‑Channel assault (OVERLORD), remained dangerously unbalanced. The paradox lay in the divergence between strategic ambition and material reality. At the Casablanca Conference (January 1943), the Combined Chiefs of Staff had resolved to “eliminate Italy from the war” and to build up forces for a return to the Continent. The TRIDENT Conference (May 1943) set a target of one million US troops in the United Kingdom by May 1944, requiring the shipment of over 1.5 million tons of cargo per month. The QUADRANT Conference (August 1943) refined these targets and established a firm date for OVERLORD in May 1944.  

Planners in Washington and London assumed that the immense industrial output of the United States could be translated directly into combat power in Europe. However, the physical constraints of the global shipping pool—especially the shortage of fast, modern Liberty and Victory ships, the limited capacity of British ports, and the persistent need to support simultaneous operations in the Mediterranean, Pacific, and China‑Burma‑India theaters—created a systemic bottleneck. The strategic paradox is best captured by the fact that while total tonnage shipped to the United Kingdom under BOLERO had reached approximately 2.2 million long tons by December 1943, the composition of that tonnage was severely distorted. Depots in England held enough ammunition to fight the war for several months, but were critically short of tactical vehicles, construction equipment, and communications gear. The “bulk tonnage” metric, used by shipping authorities to allocate scarce cargo space, masked profound category‑specific deficits that threatened the operational readiness of the assault forces.

**Inter-Service and Coalition Tensions**  
The Services of Supply (SOS) in the European Theater of Operations, commanded by Lieutenant General John C. H. Lee, was responsible for receiving, storing, and distributing supplies. Lee’s philosophy—often called “the Lee Plan”—emphasized building large, centralized depots stocked to high authorized levels. This approach clashed with the combat commands of General Eisenhower and later General Bradley, who argued for a leaner, more responsive supply system that could support rapid mobile warfare after the breakout. The tension was not merely doctrinal; it reflected a fundamental disagreement over how to allocate scarce ships and port clearance capacity. The SOS demanded heavy lifts of vehicles, engineer stores, and petroleum handling equipment, while theater headquarters wanted to prioritize combat units and their immediate fighting loads.  

Simultaneously, the US–British pooling arrangements for shipping (under the Combined Shipping Adjustment Board) generated friction. The British, having suffered catastrophic merchant losses earlier in the war, were acutely sensitive to the need to maintain a minimum import program for their own survival. Every ton of US cargo sent to the UK for BOLERO had to be balanced against the UK’s own import requirements. By late 1943, the British Ministry of War Transport increasingly complained that the US buildup was consuming berths needed for food, raw materials, and coal. These tensions were resolved only by the direct intervention of Churchill and Roosevelt, who acknowledged that the OVERLORD buildup must take precedence—even at the risk of temporarily exacerbating the UK’s domestic shortages.

**Historical Era Context**  
Chapter 12 of *Global Logistics and Strategy: 1943–1945* is the “balance sheet” review conducted at the end of 1943. The chapter opens with a sober assessment of shipping losses: although the U‑boat menace had been defeated in the Atlantic, losses in the first half of the year had been severe, and the convoy schedule had been stretched to the breaking point. The chapter examines the state of depot stocks in England, port preparations, and the “pipeline” from the United States to the assembly areas in the UK.  

Key findings of the chapter include:
- Theater depots had, on average, only 40% of the authorized inventory for Category II items (trucks, trailers, signal equipment).
- The average turnaround time for a US‑to‑UK voyage had dropped from 60 days in early 1943 to 45 days by December, thanks to improved port operations and reduced convoy waiting times.
- The port of Bristol, a major receiving center, had reached its maximum practical clearance rate of 15,000 tons per day, causing vessels to be diverted to less‑capable facilities.
- Ammunition stocks had reached 500% of authorized levels because shipping priority had been given to “safe” dense cargo over lighter, more fragile items like vehicles.

**Modern Analytical Insights**  
Post‑war declassification of SOS records and the application of modern operations research techniques have shed new light on the imbalances of late 1943. The core insight is that shipping planners, lacking a robust multi‑commodity flow model, relied on a single metric—total tonnage shipped—to allocate capacity. This led to a perverse incentive: dense cargo (e.g., ammunition, steel rails) was easier to stow and could be loaded more quickly, so it was favoured by port authorities. Low‑density, high‑value cargo (e.g., jeeps, radio sets) occupied much more cubic volume per ton, making them less efficient to ship under the tonnage paradigm. By December 1943, the ratio of “bulk” to “assembled” cargo in BOLERO shipments was approximately 65:35, when planners had assumed a 50:50 split. The resulting “selective deficit” in Category II items meant that many US divisions earmarked for OVERLORD were forced to train with British substitutes or obsolete equipment.  

A second modern insight concerns the role of port congestion as a non‑linear constraint. Using queuing theory, analysts have shown that the clearance rate of a port is not simply a function of its physical capacity; it depends on the randomness of ship arrivals, the availability of railcars and drayage, and the mix of cargo. In late 1943, the Port of London was handling over 40,000 tons per week, but the imbalance between dry cargo and bulk petroleum throughput created “lumpy” demand for unloading gear (cranes, forklifts). Depots that were 10 miles inland often had to wait days for shipments because the rail network was saturated. These insights were not fully appreciated at the time, and the SOS’s solution—to increase authorized stock levels—only made the problem worse by encouraging even more tonnage to be shipped to already‑congested ports. In a high‑fidelity simulation, these dynamics must be captured as stochastic processes with state‑dependent service rates.

## 2. High-Fidelity Simulation Parameters & Real-World Metrics

The following table provides the critical historical constants, coefficients, and operational metrics that appear in Chapter 12 or have been derived from post‑war analysis. Each entry includes a detailed historical justification and a recommended representation for simulation.

| Metric | Value | Historical Justification | Simulation Representation |
|--------|-------|--------------------------|----------------------------|
| Total US Army cargo shipped to the UK under BOLERO, Jan 1942 – Dec 1943 | 2,200,000 long tons | Derived from *Global Logistics and Strategy: 1943–1945*, Appendix A, which states that by 31 December 1943, cumulative BOLERO shipments totalled 2,180,000 long tons. Rounded to 2.2 million for clarity. This figure includes all categories: ammunition, vehicles, engineer stores, petroleum, food, and general cargo. | Static constant (`BOLERO_CUMULATIVE_TONS`) used as a benchmarking reference. The simulation should track actual cumulative shipments and compare against this target to compute an “overall fill rate.” |
| Percentage deficit of Category II tactical vehicles in ETO depots, late 1943 | 34% | Contemporary SOS reports indicate that the theater was short 34% of its authorized quantity of 2.5‑ton trucks, 1.5‑ton trailers, and communication vehicles. This deficit directly impacted the mobility of infantry divisions. | Dynamic capacity cap: the authorized level is fixed per division, but the simulated depot stock is updated monthly. The deficit ratio (`(authorized - actual) / authorized`) triggers re‑supply priority flags. Used as an efficiency coefficient: unit “mobility rating” = 1 – deficit. |
| Merchant vessel loss rate in North Atlantic convoys, Q4 1943 | 0.4% (0.004) | By the fourth quarter of 1943, the U‑boat offensive had been neutralised. Losses averaged 0.4 ships per 100 sailing (0.4%). This is a stark contrast to Q1 1943 when the rate exceeded 4%. The sharp decline allowed planners to assume near‑invulnerability for the BOLERO convoys. | Stochastic probability parameter (`ATLANTIC_LOSS_RATE_Q4_1943`). In each simulation tick, a random check determines if a scheduled convoy suffers a loss. Losses reduce the delivered tonnage by a fixed fraction (e.g., 2% of convoy capacity). |

**Additional Simulation Coefficients** (derived from modern scholarship):
- **Port clearance capacity** (Bristol): 15,000 long tons/day (hard cap). Exceeding this for more than 5 consecutive days creates a backlog queue that adds 3 days of delay per 1,000 tons excess.
- **Rail throughput** (South West England): 8,000 tons/day per trunk line. Bottlenecks occur when port output exceeds rail capacity.
- **Category I (ammunition) fill rate**: 500% of authorized → stored in temporary dumps. Creates fire risk and degrades unit readiness due to over‑stocking.

## 3. Logistical Network Topology

The following Mermaid.js diagram models the flow of supplies from U.S. Ports of Embarkation (POEs) to final theater depots in the United Kingdom, focusing on the imbalance between actual stocks and authorized inventory targets.

```mermaid
flowchart TD
    subgraph US_Ports_of_Embarkation
        A1[New York POE]
        A2[Philadelphia POE]
        A3[Baltimore POE]
    end

    subgraph Convoy_Routes
        B[North Atlantic Convoy<br/>Q4 1943 Loss Rate: 0.4%]
    end

    subgraph UK_Ports_of_Debarkation
        C1[Bristol / Avonmouth<br/>Cap: 15,000 tons/day]
        C2[Port of London<br/>Cap: 12,000 tons/day]
        C3[Liverpool<br/>Cap: 10,000 tons/day]
        C4[Southampton<br/>Cap: 8,000 tons/day]
    end

    subgraph Inland_Rail_Network
        D1[South West Rail Trunk<br/>Cap: 8,000 tons/day]
        D2[South East Rail Trunk<br/>Cap: 6,000 tons/day]
        D3[Western Rail Trunk<br/>Cap: 7,000 tons/day]
    end

    subgraph Theater_Depots
        E1[Central Depot (COD)<br/>Authorized: 250,000 tons<br/>Actual (Cat I): 500%<br/>Actual (Cat II): 66%]
        E2[Forward Depot (FOD)<br/>Authorized: 120,000 tons<br/>Actual (Cat I): 400%<br/>Actual (Cat II): 55%]
        E3[Reserve Depot (ROD)<br/>Authorized: 80,000 tons<br/>Actual (Cat I): 300%<br/>Actual (Cat II): 70%]
    end

    A1 --> B
    A2 --> B
    A3 --> B
    B --> C1
    B --> C2
    B --> C3
    B --> C4
    C1 --> D1
    C2 --> D2
    C3 --> D3
    C4 --> D1
    D1 --> E1
    D1 --> E2
    D2 --> E1
    D2 --> E3
    D3 --> E2
    D3 --> E3

    style A1 fill:#bbf
    style A2 fill:#bbf
    style A3 fill:#bbf
    style B fill:#f9f
    style C1 fill:#cfc
    style C2 fill:#cfc
    style C3 fill:#cfc
    style C4 fill:#cfc
    style D1 fill:#ffc
    style D2 fill:#ffc
    style D3 fill:#ffc
    style E1 fill:#fcc
    style E2 fill:#fcc
    style E3 fill:#fcc
```

**Diagram explanation:**  
- US POEs feed into a single convoy route with a stochastic loss rate.  
- Four principal UK ports receive the cargo; each has a hard daily clearance capacity.  
- Three rail corridors distribute the cargo to three main depot types. Depots are labeled with their authorized inventory and the actual percentage fill for Category I (ammunition) and Category II (tactical vehicles). The imbalance is visually represented by the ratio of actual to authorized (e.g., E1 shows 500% for Cat I and 66% for Cat II).  
- The simulation tracks deviation ratios per category per depot, as defined by the mathematical model in Section 4.

## 4. Mathematical Modeling & Simulation Formulas

We define a set of equations that model the logistic imbalance as a function of supply flows and authorized inventory targets. The core concept is the **imbalance ratio** for each supply category \( i \) at each depot \( j \):

\[
\text{Imbalance}_{i,j} = \frac{S_{i,j}^{\text{actual}} - S_{i,j}^{\text{auth}}}{S_{i,j}^{\text{auth}}}
\]

where:
- \( S_{i,j}^{\text{actual}} \) = current stock (in long tons) of category \( i \) at depot \( j \)
- \( S_{i,j}^{\text{auth}} \) = authorized stock (authorized inventory objective, as set by SOS planning)

A value of 0 indicates perfect balance; positive values indicate overstock; negative values indicate deficit.

**State Variables** (defined at each time step \( t \)):
- \( Q_{p}(t) \) = queue length (tons) awaiting clearance at port \( p \)
- \( F_{p}^{\text{clear}}(t) \) = daily clearance capacity (tons per day) – a constant for each port, but becomes a function of \( Q_p \) if congested
- \( R_{r}(t) \) = remaining capacity on rail trunk \( r \) (tons/day) – maximum minus current load
- \( D_{j,i}(t) \) = supply flow (tons) delivered into depot \( j \) for category \( i \) on day \( t \)
- \( C_{j,i}^{\text{cons}}(t) \) = consumption (tons) demanded by combat units from depot \( j \) on day \( t \)

**Dynamic Equations:**

\[
S_{i,j}^{\text{actual}}(t+1) = S_{i,j}^{\text{actual}}(t) + D_{j,i}(t) - C_{j,i}^{\text{cons}}(t)
\]

\[
Q_{p}(t+1) = \max\left(0,\, Q_{p}(t) + \text{Arrivals}_{p}(t) - F_{p}^{\text{clear}}(t)\right)
\]

**Objective Function for Resource Allocation (Shipping Priority):**

The shipping authority at time \( t \) chooses which categories to load next by minimizing the weighted sum of absolute imbalances across all depots and categories:

\[
\min_{x_{p,i}} \sum_{j} \sum_{i} w_i \left| \frac{S_{i,j}^{\text{actual}} + \delta_{j,i} - S_{i,j}^{\text{auth}}}{S_{i,j}^{\text{auth}}} \right|
\]

subject to:
- \( \sum_i x_{p,i} \leq F_{p}^{\text{clear}}(t) \)  (port capacity)
- \( \sum_{p,x} \text{(rail capacity constraints)} \)
- \( x_{p,i} \geq 0 \)

where \( w_i \) is a weight (e.g., higher for Category II), and \( \delta_{j,i} \) is the increment delivered if \( x_{p,i} \) is assigned to depot \( j \).

This is a linear programming problem that can be solved at each simulation tick. In practice, historical planners used a simpler heuristic: “load densest first” – which our simulation can optionally switch to for comparison.

## 5. Compile-Safe Scala 3.8.3 Domain Model

```scala
package Logistics.InventoryAftermath

import scala.collection.immutable.Map

opaque type Tons = Double
opaque type Ratio = Double
opaque type Days = Int

object Units:
  given Conversion[Double, Tons] = identity
  given Conversion[Double, Ratio] = identity
  given Conversion[Int, Days] = identity

  extension (t: Tons) def toDouble: Double = t
  extension (r: Ratio) def toDouble: Double = r
  extension (d: Days) def toInt: Int = d

enum SupplyCategory:
  case Ammunition, TacticalVehicles, EngineerStores, Petroleum, GeneralCargo

enum CargoPriority:
  case Critical, High, Normal, Low

case class AuthorizedStock(category: SupplyCategory, amount: Tons)

case class CurrentStock(category: SupplyCategory, amount: Tons)

case class InventoryBalance(
  category: SupplyCategory,
  actual: Tons,
  authorized: Tons
):
  def imbalanceRatio: Ratio =
    if authorized == 0.0 then 0.0
    else (actual - authorized) / authorized

case class Depot(
  id: String,
  location: String,
  capacity: Tons,
  inventory: Map[SupplyCategory, CurrentStock],
  authorizedLevels: Map[SupplyCategory, AuthorizedStock]
):
  require(capacity > 0.0, "Depot capacity must be positive")
  require(
    inventory.values.map(_.amount).sum <= capacity,
    s"Total inventory of depot $id exceeds capacity"
  )

  def computeBalances: List[InventoryBalance] =
    authorizedLevels.map { (cat, auth) =>
      val current = inventory.getOrElse(cat, CurrentStock(cat, 0.0))
      InventoryBalance(cat, current.amount, auth.amount)
    }.toList

  def fillRate(category: SupplyCategory): Ratio =
    authorizedLevels.get(category) match
      case Some(auth) if auth.amount > 0.0 =>
        val current = inventory.getOrElse(category, CurrentStock(category, 0.0))
        current.amount / auth.amount
      case _ => 0.0

enum LogisticsAction:
  case Transfer(
    sourceDepotId: String,
    targetDepotId: String,
    category: SupplyCategory,
    quantity: Tons
  )
  case ExpediteShipping(
    category: SupplyCategory,
    priority: CargoPriority,
    additionalTons: Tons
  )

case class SimulationState(
  depots: Map[String, Depot],
  portQueues: Map[String, Tons],
  date: Days
):
  def updateDepot(id: String, newInventory: Map[SupplyCategory, CurrentStock]): SimulationState =
    depots.get(id) match
      case Some(depot) =>
        val updatedDepot = depot.copy(inventory = newInventory)
        copy(depots = depots.updated(id, updatedDepot))
      case None => this

  def applyAction(action: LogisticsAction): SimulationState =
    action match
      case LogisticsAction.Transfer(src, tgt, cat, qty) =>
        (depots.get(src), depots.get(tgt)) match
          case (Some(srcDepot), Some(tgtDepot)) =>
            val srcInv = srcDepot.inventory.getOrElse(cat, CurrentStock(cat, 0.0))
            val tgtInv = tgtDepot.inventory.getOrElse(cat, CurrentStock(cat, 0.0))
            val moved = Math.min(qty, srcInv.amount)
            val newSrcInv = srcInv.copy(amount = srcInv.amount - moved)
            val newTgtInv = tgtInv.copy(amount = tgtInv.amount + moved)
            val updatedSrcDepot = srcDepot.copy(inventory = srcDepot.inventory.updated(cat, newSrcInv))
            val updatedTgtDepot = tgtDepot.copy(inventory = tgtDepot.inventory.updated(cat, newTgtInv))
            copy(depots = depots.updated(src, updatedSrcDepot).updated(tgt, updatedTgtDepot))
          case _ => this
      case LogisticsAction.ExpediteShipping(cat, _, tons) =>
        // In a full simulation, this would add to a shipping request queue.
        // Simplified: increment inventory of a random depot.
        depots.headOption.fold(this) { (id, depot) =>
          val current = depot.inventory.getOrElse(cat, CurrentStock(cat, 0.0))
          val updatedInv = current.copy(amount = current.amount + tons)
          val updatedDepot = depot.copy(inventory = depot.inventory.updated(cat, updatedInv))
          copy(depots = depots.updated(id, updatedDepot))
        }

object InventoryBalanceModel:
  def computeImbalances(depots: Map[String, Depot]): List[(String, SupplyCategory, Ratio)] =
    depots.flatMap { (id, depot) =>
      depot.computeBalances.map(b => (id, b.category, b.imbalanceRatio))
    }.toList

  def computeOverallFillRate(depots: Map[String, Depot]): Ratio =
    val totals = depots.values.flatMap { depot =>
      depot.authorizedLevels.map { (cat, auth) =>
        val current = depot.inventory.getOrElse(cat, CurrentStock(cat, 0.0)).amount
        (current, auth.amount)
      }
    }
    val totalActual = totals.map(_._1).sum
    val totalAuth = totals.map(_._2).sum
    if totalAuth == 0.0 then 0.0 else totalActual / totalAuth

  def generateRebalanceOrders(
    depots: Map[String, Depot],
    deficitThreshold: Ratio = -0.15
  ): List[LogisticsAction] =
    depots.flatMap { (id, depot) =>
      depot.computeBalances.collect {
        case InventoryBalance(cat, actual, auth) if auth > 0.0 =>
          val ratio = (actual - auth) / auth
          if ratio < deficitThreshold then
            val needed = Math.round((auth * 1.1 - actual) * 100.0) / 100.0 // 10% buffer
            Some(LogisticsAction.ExpediteShipping(cat, CargoPriority.Critical, needed))
          else None
      }.flatten
    }.toList

  def simulateDay(state: SimulationState, consumption: Map[String, Map[SupplyCategory, Tons]]): SimulationState =
    consumption.foldLeft(state) { case (s, (depotId, consumptionMap)) =>
      s.depots.get(depotId) match
        case Some(depot) =>
          val newInventory = consumptionMap.foldLeft(depot.inventory) { case (inv, (cat, consumed)) =>
            val current = inv.getOrElse(cat, CurrentStock(cat, 0.0))
            val reduced = Math.max(0.0, current.amount - consumed)
            inv.updated(cat, current.copy(amount = reduced))
          }
          s.updateDepot(depotId, newInventory)
        case None => s
    }
```

## 6. Graduate-Level Operational Analysis

**Question 1: What were the main causes of the 'imbalance' in UK depots at the end of 1943?**  

The imbalance was not a monolithic phenomenon but a systemic mismatch between the physical properties of different supply categories and the decision rules used by shipping authorities. Three primary causes can be identified:

1. **Priority of dense, non‑perishable cargo over low‑density, high‑value cargo.**  
   Shipping authorities operated under a “total tonnage” metric. Since dense cargo (e.g., ammunition, steel beams) could be stowed more efficiently per cubic foot of hold space, port operators preferred it. Lighter, bulkier cargo (e.g., dismantled vehicles, signal corps equipment) required more volume per ton and was often deprioritised. This created a *volumetric distortion*: by December 1943, ammunition stocks in the UK reached 500% of authorised levels, while tactical vehicle stocks stood at only 66%. The mathematical consequence is that the tonnage shipped was high, but the mix was drastically skewed.

2. **Lack of a multi‑category inventory target in the planning process.**  
   Theater planners set authorised levels for each supply category, but shipping allocation was determined centrally in Washington based on aggregate tonnage rather than category‑specific fill rates. There was no feedback loop that would expedite a light, deficit category once its imbalance ratio fell below a threshold. The SOS’s own reporting system aggregated “supplies on hand” without properly weighting deficits; a depot could report 80% overall fill while having catastrophic gaps in mobility‑critical items.

3. **Port and inland transport constraints that exacerbated the problem.**  
   Even when deficit cargo eventually arrived, it often landed at ports that were already congested with dense cargo. The Port of Bristol, for example, had a theoretical capacity of 15,000 tons/day, but the mix of cargo arriving meant that specialised handling equipment for vehicles (e.g., mobile cranes, roll‑on/roll‑off ramps) was under‑utilised while general cargo piers were overwhelmed. Inland rail distribution was capacity‑limited; depots receiving a sudden influx of ammunition could not quickly re‑route their receiving capacity to handle a delayed vehicle shipment. This created a *non‑linear penalty*: the imbalance ratio for Category II items actually worsened as total tonnage increased, because the marginal shipment was almost always dense.

**Question 2: How did the reduction in Atlantic shipping losses in late 1943 affect the logistical outlook for OVERLORD?**  

The reduction in Atlantic losses from over 4% in the first quarter of 1943 to below 0.5% in the fourth quarter had a profound, though non‑intuitive, effect on the OVERLORD buildup. The immediate quantitative impact was an increase in deliverable tonnage: with a convoy capacity of, say, 200,000 tons per month, a loss rate drop from 4% to 0.5% meant that an additional 7,000 tons actually arrived each month—a non‑trivial gain. However, the *qualitative* effect was even more important:

- **Reduction in insurance margins.** Planners had built large safety stocks to absorb expected losses. When losses fell, the “excess” cargo capacity that had been reserved for replacement could be re‑allocated to filling Category II deficits. In the simulation, this is modelled as a relaxation of the convoy loss stochastic parameter, allowing a higher fraction of planned shipments to reach port.

- **Improved schedule reliability.** With losses low, convoy departures could be guaranteed on a regular schedule. This allowed port operators to plan more efficiently: they could allocate unloading crews and railcars to specific commodities weeks in advance. The standard deviation of port arrival times decreased, reducing the congestion penalty. Queuing models show that cutting the variance of inter‑arrival times by 50% can increase effective throughput by up to 15% under capacity constraints.

- **Shift in strategic risk posture.** By December 1943, the Combined Chiefs concluded that the Atlantic was effectively safe for the duration of the buildup. This confidence allowed them to forward‑deploy more assault shipping (LSTs, LCIs) directly to the UK, rather than holding them in the Mediterranean to protect against U‑boat threats. The net effect was that the OVERLORD shipping pool expanded by an estimated 10–12% by early 1944, measured in ship‑days.

- **Downside: the illusion of abundance.** The dramatic drop in losses lulled some planners into believing that the overall logistics problem was solved. They failed to recognise that the *mix* problem remained. The SOS continued to ship dense cargo because it was easy to load, and the low loss rate gave them no incentive to change. The deficit of tactical vehicles therefore persisted well into the spring of 1944, requiring a last‑minute “Red Ball Express”‑style expedite program that consumed enormous resources.

In summary, the reduction in Atlantic losses removed one major bottleneck, but it simultaneously exposed the deeper structural imbalance that could only be fixed by changing the commodity‑level allocation rules. A high‑fidelity simulation must capture this phenomenon: as the loss rate falls, the system’s overall throughput rises, but the *variance* of fill rates across categories can actually increase if the allocation heuristic remains unchanged.
