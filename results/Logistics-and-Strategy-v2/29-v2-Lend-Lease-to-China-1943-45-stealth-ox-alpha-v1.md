Cost: 0

# Reference Manual & Simulation Specification
## Chapter 29 — *Global Logistics and Strategy: 1943–1945* (Coakley & Leighton, U.S. Army Green Books): **Lend-Lease to China, 1943–45**

**Document class:** Principal Operations Research Analyst / Military Logistics Historian / Senior Systems Architect joint specification
**Target engine:** Division-level WWII logistics simulator, CBI (China-Burma-India) module

---

## 1. Strategic Context & Modern Historical Perspective

### 1.1 The Terminal Problem of a 12,000-Mile Pipeline

Lend-Lease to China in 1943–1945 was the terminal segment of the longest and most fragile supply line sustained by any Allied army in the Second World War. Material moved from American factories to Atlantic, Persian Gulf, and Indian Ocean ports, thence through the Red Sea or around the Cape, into Indian ports whose clearance systems were already saturated by Britain's own war effort, onto the single-track Bengal–Assam Railway, and finally — after the loss of Burma in May 1942 severed the Burma Road — over the Himalayan "Hump" by air, or (from early 1945) over the reconstructed Ledo–Stilwell Road and its companion petroleum pipeline. Every ton delivered to Kunming therefore embodied four or five inter-modal transfers, each with its own queue, its own seasonal rhythm, and its own institutional owner. The Green Book chapter under specification is fundamentally a study of how a political commitment (the maintenance of China as an active belligerent) collided with a physical system whose steady-state capacity was measured in hundreds of tons per day while the political demand was measured in divisions.

### 1.2 The Strategic Paradox: Conference Promises versus Ship-Ton-Days

The conference architecture of 1943 generated commitments that the global transportation pool could not honor, and the mechanism of that failure is essential to model correctly. At **Casablanca (January 1943)**, the Combined Chiefs endorsed an ambitious reconquest of northern Burma (ANAKIM) designed to reopen the land route. At **TRIDENT (Washington, May 1943)**, Roosevelt personally pledged Chiang Kai-shek an expanded Hump airlift — the famous drive toward 10,000 tons per month, achieved in December 1943 (12,590 tons) — together with ground and naval operations against Burma. At **QUADRANT (Quebec, August 1943)** the Allies created South East Asia Command under Mountbatten and refined the amphibious concept (BUCANEER against the Andamans). At **SEXTANT (Cairo, November–December 1943)**, Chiang was promised that BUCANEER would coincide with the Yunnan offensive, and he committed the Y-Force in exchange.

The paradox crystallized within weeks: the landing craft, escort vessels, and assault shipping required for BUCANEER were the same assets being massed for OVERLORD and the Anzio (SHINGLE) landing. The Mediterranean and Channel theaters held first call on the combined assault-shipping pool administered through the Combined Shipping Adjustment Board; BUCANEER was cancelled, the Cairo bargain collapsed, and Chiang stalled the Y-Force until Roosevelt applied direct pressure in the spring of 1944. The analytical lesson for the simulator is that **strategic plans were denominated in divisions and dates, while the binding constraints were denominated in ship-ton-days, port-clearance rates, and locomotive availabilities** — incommensurable units reconciled only by ad hoc political arbitration. The 1944 global shipping crisis (OVERLORD buildup, the Pacific advance, the 90-division gamble, even the grain movements implicated in the Bengal famine) systematically stripped the CBI of margin precisely when its requirements peaked.

### 1.3 Inter-Service and Coalition Friction

Command friction in the CBI was not incidental; it was structural, arising from triple- and quadruple-hatted authority. General Joseph W. Stilwell simultaneously served as commanding general of the U.S. China-Burma-India Theater, Chief of Staff to Chiang Kai-shek, commander of the Chinese forces in Burma (X-Force), and — from late 1943 — Deputy Commander of SEAC under a British supreme commander whose strategic priorities (Rangoon, DRACULA) diverged sharply from American ones (China defense, ALPHA). Beneath him, the Services of Supply under Major General Raymond A. Wheeler fought a continuous bureaucratic battle with combat commanders over construction troops: every engineer battalion grading the Ledo Road or extending Assam airfields was a battalion unavailable for tactical employment, and vice versa.

The deepest doctrinal fault line ran between **air and ground claims on the same tonnage**. Major General Claire Chennault's Fourteenth Air Force argued that a few thousand tons per month, converted into airpower, could paralyze Japanese logistics in China; Stilwell argued that only re-equipped Chinese infantry divisions could hold territory and airfields. Because both drew from the identical Hump stream, the theater operated a perpetual monthly allocation board — air operations, B-29 (Matterhorn) support, Y-Force equipping, Z-Force training, and the Kunming stockpile all bidding against one another. The B-29 deployment to Chengtu was uniquely corrosive: supporting each XX Bomber Command sortie from China required fuel shuttles whose Hump-lift cost was measured in multiples of the strike sortie itself (ratios of roughly 6:1 to 12:1 appear in the literature). The Japanese **Operation ICHIGO** offensive (April–December 1944) then destroyed the physical premise of the airpower thesis by overrunning the eastern China airfields, triggering the ALPHA emergency and the retrograde haulage of supplies back out of collapsing depots. Stilwell's recall in October 1944, the split of the theater into the India-Burma Theater (Sultan) and China Theater (Wedemeyer), and the elevation of the ALPHA reserve constituted a formal recognition that allocation politics had become strategy.

### 1.4 Historical Era Context: The Overland Link Opens

Following the capture of Myitkyina (airfield May 1944; town August 1944) and the Salween crossings by Wei Li-huang's Y-Force, the Ledo Road — rebuilt under Brigadier General Lewis A. Pick from October 1943 ("Pick's Pike") by roughly 15,000 American engineers (a majority in African-American units) and some 35,000 Asian laborers — was joined to the repaired old Burma Road at Mong Yu/Wanting in late January 1945. The first convoy (approximately 113 vehicles) departed Ledo on **12 January 1945** and reached Kunming on **4 February 1945**; Chiang Kai-shek christened the route the **Stilwell Road**, a pointed gesture toward the recently recalled commander. In parallel, a 6-inch pipeline from Calcutta to Assam (completed 1944) was extended across northern Burma toward Kunming during 1945, and Hump tonnage — freed of much of the B-29 burden after the Marianas transition — climbed to its July 1945 peak of **71,042 tons in a single month**. Lend-Lease deliveries to China consequently rose steeply: roughly a quarter-million tons in 1944 and approaching half a million tons in 1945 through V-J Day.

### 1.5 Modern Analytical Insights

Post-war scholarship has been severe about the overland project's economics. By the time the road opened, the Hump was delivering **on the order of 85–90 percent of China's supply volume**; the road averaged only about 5,000 tons per month during its seven months of operation, and the pipeline added comparatively little before V-J Day. Direct construction costs of roughly $137–150 million (1944 dollars), plus the opportunity cost of engineer troops, bridging steel, and pipe that had competing uses in the European port-clearance and PLUTO-style programs, yield a cost-per-delivered-ton for the road that dwarfs every alternative mode. Modern operations-research readings treat the road less as a transport investment than as an **insurance option and political instrument**: it diversified a supply system dangerously exposed to weather and to any serious Japanese interdiction of the Assam airfields, it anchored the pipeline, it validated the X-Force/Y-Force campaigns that cleared it, and it signaled to Chiang that the land route — promised since 1942 — finally existed. The simulator must therefore represent the road not merely as a capacity edge but as a *redundancy term* in a reliability-weighted objective, while honestly encoding its negative expected return as a pure throughput asset.

---

## 2. High-Fidelity Simulation Parameters & Real-World Metrics

Values marked **(attested)** are firmly established in the official histories and standard datasets. Values marked **(reconstructed)** are engineering derivations from attested sub-components (equipment densities, per-machine burn rates) and should be treated as calibrated priors with the stated uncertainty bands, pending archival confirmation. Values marked **(composite est.)** sum attested and reconstructed components.

| ID | Parameter | Value | Basis | Simulator Representation |
|----|-----------|-------|-------|--------------------------|
| P-01 | First convoy departs Ledo | **12 Jan 1945** | Attested | Static date constant (`LocalDate`) |
| P-02 | **First convoy arrives Kunming** | **4 Feb 1945** (transit ≈ 23 d incl. inspections/ceremonial halts) | Attested | Static date constant; steady-state transit modeled separately |
| P-03 | Stilwell Road total length, Ledo→Kunming | ≈ 1,079 mi (1,736 km) | Attested | Static geometry constant |
| P-04 | New construction, Ledo→Mong Yu | ≈ 466 mi | Attested | Static geometry constant |
| P-05 | Repaired old Burma Road segment | ≈ 613 mi | Derived (P-03 − P-04) | Static geometry constant |
| P-06 | Hump route length (Assam↔Kunming pairings) | ≈ 520–700 nm | Attested | Route-pair lookup table |
| P-07 | Hump monthly tonnage, Dec 1943 | 12,590 t | Attested | Calibration point for airlift growth curve |
| P-08 | Hump monthly tonnage, Nov 1944 | ≈ 34,900 t | Attested | Calibration point |
| P-09 | **Hump peak month, Jul 1945** | **71,042 t** (≈ 2,290 t/d) | Attested | Dynamic capacity ceiling (time-varying) |
| P-10 | **LL tonnage to China, CY1944** | **≈ 251,000 short tons** (essentially 100% Hump) | Attested aggregate | Annual accumulator; validates inflow integrator |
| P-11 | **LL tonnage to China, CY1945 (through V-J Day)** | **≈ 440,000–460,000 short tons composite**: Hump ≈ 395,000 (Jan–Aug; ≈ 366,700 attested Jan–Jul) + road ≈ 33,000 + pipeline ≈ 25,000 | Composite est. | Annual accumulator with per-mode decomposition |
| P-12 | Road convoy size (steady-state) | 200–250 trucks | Attested (planning norms) | Discrete dispatch quantum `N` |
| P-13 | Nominal truck payload (GMC 2.5-t class, mountain loading) | 2.0–2.5 t effective | Attested | Payload coefficient `p̄` |
| P-14 | Steady-state one-way transit, Ledo→Kunming | ≈ 6–8 d (dry season) | Reconstructed from segment speeds | Transit-time state `τ(t)` |
| P-15 | Convoy dispatch interval | ≈ 1 d | Attested planning norm | Cycle parameter `δ` |
| P-16 | **Actual road throughput, Feb–Aug 1945** | ≈ 5,000 t/month (≈ 165 t/d); cumulative ≈ 35,000–50,000 t | Attested order-of-magnitude | Validation target for Eq. (2) |
| P-17 | Pipeline throughput to Kunming | ≈ 150–250 t/d (est.); cumulative ≈ 25,000 t to V-J Day | Reconstructed | Parallel-mode capacity edge |
| P-18 | Calcutta effective import clearance | ≈ 4,000–4,500 t/d (wartime avg., est.) | Reconstructed | Source-node capacity cap |
| P-19 | Bengal–Assam Ry. net throughput to Assam | ≈ 800–1,200 t/d (1943) → ≈ 2,800–3,200 t/d (1945, post-improvement) | Reconstructed | Time-varying edge capacity |
| P-20 | Bahadurabad ferry delay | +1 to +3 d mean | Attested qualitatively | Stochastic delay distribution |
| P-21 | Hump aircraft committed, mid-1945 | ≈ 640 transports | Attested | Fleet state `A(t)` |
| P-22 | Cumulative Hump losses | ≈ 594 aircraft; ≈ 1,300+ aircrew KIA/MIA | Attested | Attrition coefficient calibration |
| P-23 | Engineer strength, road project (peak) | ≈ 15,000 U.S. (≈ 60% African-American units) + ≈ 35,000 laborers | Attested | Manpower state vector |
| P-24 | Heavy plant on road project | ≈ 300 dozers, 150 graders, 80 shovels; ≈ 2,400 trucks | Reconstructed from unit tables | Equipment state vector |
| P-25 | **Daily fuel demand, road construction units, Burma (1944 peak)** | **≈ 46,000 US gal/d** (band 40,000–55,000): heavy plant ≈ 20,450 (dozers 300×45; graders 150×25; shovels 80×40) + trucks 2,400×9 ≈ 21,600 + auxiliaries ≈ 4,000 | Reconstructed (see derivation below) | Stochastic POL demand at construction node, CV ≈ 0.15 |
| P-26 | Direct road construction cost | ≈ $137–150 M (1944 USD), excl. LL equipment amortization | Attested range | Capital-cost ledger entry |
| P-27 | Fatalities, road construction | ≈ 1,100+ U.S.; laborers in the thousands (disease-dominant) | Attested order-of-magnitude | Attrition/welfare state |
| P-28 | Official exchange rate | 20 fabi = US$1 (frozen through the war) | Attested | Fixed accounting constant `e_off` |
| P-29 | Free-market fabi/USD divergence | Order of magnitude above official by 1944; two orders by mid-1945 | Attested qualitatively | Exogenous spread process `g(t)` |
| P-30 | Free-China wholesale price inflation | ≈ 5–6× per year during 1944–45 (Chungking index, 1937 = 100; order-of-magnitude per Young's series) | Approximation | Geometric drift `π(t)` |
| P-31 | U.S. Treasury instruments | $500 M 1942 loan (exhausted ≈ 1944); gold deliveries ≈ $200 M+ by V-J Day (themselves Hump-lift-consuming) | Attested/approximate | Policy-lever switches |

**Derivation note for P-25.** No single canonical archival figure for aggregate construction-fuel burn survives in the Green Book narrative; the value above is synthesized bottom-up from attested equipment densities (P-24) and standard 1944 consumption tables for the Caterpillar D7/D8 class and 2.5-ton trucks under jungle-earthwork duty cycles. It is deliberately exposed as a *stochastic parameter*, not a constant, so the engine can propagate its uncertainty band.

---

## 3. Logistical Network Topology (Mermaid.js)

**Simulation focus:** convoy throughput over primitive overland roads — daily tonnage as a function of transit delay, dispatch interval, and seasonal degradation — embedded in the full multi-modal chain from ports of embarkation to theater depots.

```mermaid
flowchart LR

subgraph PORTS["POE — Indian Ocean Ports"]
  CAL["Calcutta<br/>Primary POE<br/>clearance cap ≈ 4,500 t/d"]
  CGP["Chittagong<br/>Alternate POE"]
  BOM["Bombay / Karachi<br/>Contingency POE"]
end

subgraph RAILNET["Bengal–Assam Railway"]
  PAR["Parbatipur<br/>Broad-to-meter gauge break<br/>delay +0.5 d"]
  BAH["Bahadurabad ferry<br/>Brahmaputra crossing<br/>delay +1 to +3 d"]
  PAN["Pandu Ghat"]
  TSK["Tinsukia yard"]
end

subgraph ASSAM["Assam Base Section"]
  ADB["Assam base depots<br/>consolidation stockpile"]
  CHB["Chabua field"]
  JRH["Jorhat field"]
  MIS["Misamari field"]
  LED["Ledo<br/>roadhead and pipe head"]
end

subgraph AIR["ATC Hump Corridor"]
  HMP{"Himalayan crossing<br/>ceiling ≈ 2,300 t/d at Jul-45 peak<br/>weather and attrition derates"}
end

subgraph ROAD["Ledo–Stilwell Road Convoy Spine"]
  PP["Pangsau Pass<br/>4,500 ft"]
  SHB["Shingbwiyang"]
  WRZ["Warazup"]
  MYT["Myitkyina<br/>all-weather after Aug-44"]
  BHM["Bhamo"]
  WNT["Mong Yu – Wanting<br/>junction with old Burma Road"]
  LGL["Lungling"]
  PSN["Paoshan"]
  XKW["Hsiakwan"]
end

subgraph PIPE["POL Pipeline System"]
  PIP["6-in trunk Calcutta to Tinsukia<br/>4-in Ledo to Kunming spur<br/>≈ 150 to 250 t/d est."]
end

subgraph CHINA["China Theater Distribution Net"]
  KMG["Kunming depot complex<br/>primary receiving and breakout"]
  ALR["ALPHA reserve<br/>east-China airfield defense"]
  CTU["Chengtu B-29 complex<br/>XX Bomber Command"]
  EAF["Fourteenth AF forward fields"]
  YF["Y-Force, Yunnan"]
  ZF["Z-Force training base"]
end

CAL -->|"broad-gauge rail cap ≈ 2,200 t/d"| PAR
CGP -.->|"meter-gauge feeder"| PAR
BOM -.->|"long-haul contingency routing"| PAR
PAR -->|"meter-gauge rail"| BAH
BAH -->|"ferry plus valley rail"| PAN
PAN -->|"valley rail cap ≈ 1,400 t/d"| TSK
TSK --> ADB
ADB -->|"truck issue to wings"| CHB
ADB --> JRH
ADB --> MIS
CHB -->|"C-46 and C-87 sorties"| HMP
JRH --> HMP
MIS --> HMP
HMP ==>|"mean 1,500 to 2,300 t/d 1945"| KMG
ADB -->|"convoy dispatch, delta ≈ 1 d"| PP
PP -->|"primitive mountain track"| SHB
SHB --> WRZ
WRZ --> MYT
MYT -->|"engineered all-weather grade"| BHM
BHM --> WNT
WNT -->|"repaired old Burma Road"| LGL
LGL --> PSN
PSN --> XKW
XKW -->|"observed ≈ 165 t/d convoy ceiling"| KMG
CAL -->|"pipeline feed"| PIP
PIP --> KMG
MYT -.->|"forward-field offload shortens Hump leg"| HMP
KMG --> ALR
KMG --> CTU
KMG --> EAF
KMG --> YF
KMG --> ZF

classDef bottleneck stroke:#b30000,stroke-width:3px,color:#b30000;
classDef highcap stroke:#1a7a1a,stroke-width:2px;
classDef seasonal stroke:#b26a00,stroke-width:2px,stroke-dasharray:5 5;
class HMP,BAH,PAR,XKW bottleneck;
class PIP,KMG highcap;
class CGP,BOM seasonal;
```

**Topology notes for the engine.** (i) Pre-August 1944, the Myitkyina node is closed and the Hump leg is longer and more exposed; the graph must support time-varying edge existence. (ii) The governing min-cut migrates: 1943–44 it sits at the BAR ferry/transshipment complex; by mid-1945 it sits at the Hump weather ceiling and Kunming breakout. (iii) The road spine is a *serial* system — its capacity equals the minimum segment capacity, with Pangsau Pass and the Bhamo approaches as the constraining links under monsoon loading.

---

## 4. Mathematical Modeling & Simulation Formulas

### 4.1 Baseline Convoy Throughput (Batch-Cycle Server)

$$\text{Convoy Throughput: }\quad T_{\text{road}} \;=\; \frac{N \cdot \bar{p}}{\delta + \tau}$$

where $N$ = trucks per convoy (vehicles), $\bar{p}$ = mean effective payload (tons/truck), $\tau$ = one-way transit time (days), $\delta$ = dispatch interval between convoy departures (days). This is a deterministic cyclic-server relation equivalent to Little's Law applied to the road as a single server with cycle period $P = \delta + \tau$: each cycle injects $N\bar p$ tons, hence the rate. Work-in-process on the road at any instant is $N\bar p \cdot \lceil \tau/\delta\rceil$ tons. **Simulator representation:** core kernel function; $\delta$, $\tau$, $N$, $\bar p$ are controllable inputs; $T_{\text{road}}$ is the edge flow.

*Worked check:* $N=200$, $\bar p = 2.2$ t, $\tau = 6$ d, $\delta = 1$ d ⇒ $T = 440/7 \approx 62.9$ t/d ≈ 1,890 t/mo gross — below the observed ≈ 165 t/d ceiling, confirming that observed throughput was set by larger dispatched formations and shorter effective cycles in the dry season, and validating the need for the seasonal/fleet terms below.

### 4.2 Seasonal, Attrition-Adjusted, Fleet-Constrained Throughput

$$T_{\text{eff}}(t) \;=\; \underbrace{\eta\big(\text{season}(t)\big)}_{\text{monsoon factor}}\;\big(1-\lambda_b\big)\;\min\!\left[\frac{N\bar p}{\tau_0\, g_w(t) + \delta},\;\frac{F_{\text{avail}}(t)\,\bar p}{\tau_0\, g_w(t) + \delta}\right]$$

with $\eta \in \{1.0,\,0.85,\,0.45\}$ for Dry/Transition/Monsoon; $\lambda_b$ = daily breakdown attrition fraction; $g_w(t)$ = weather-grade transit multiplier ($g_w \ge 1$); $F_{\text{avail}}$ = mechanically available trucks. The `min` operator captures the two regimes observed historically: a **dispatch-bound** regime (early 1945, road newly opened) and a **fleet-bound** regime (once demand exceeded vehicle availability). **Representation:** $\eta$ = discrete seasonal coefficient; $\lambda_b, g_w$ = stochastic coefficients; $F_{\text{avail}}$ = dynamic state.

### 4.3 Fleet Evolution Under Attrition and Reinforcement

$$F_{\text{avail}}(t+1) \;=\; F_{\text{avail}}(t)\,\big(1-\rho_m-\rho_c\big) \;+\; R(t)$$

$\rho_m$ = mechanical-loss rate, $\rho_c$ = accident/combat loss rate, $R(t)$ = replacement arrivals (subject to the same upstream pipeline delays as cargo). **Representation:** first-order lag state; calibrate so that steady-state $F_{\text{avail}} \approx 0.7\,F_{\text{assigned}}$ (consistent with attested availability norms).

### 4.4 Hump Airlift Module

$$T_{\text{air}}(t) \;=\; A(t)\,u\;\bar p_{\text{eff}}\,\big(1-\ell_s\big), \qquad \bar p_{\text{eff}} \;=\; p_0\,\kappa_{DA}(h,\theta)\,\kappa_{\text{load}}$$

$A(t)$ = committed transports, $u$ = sorties per aircraft-day, $\ell_s$ = sortie loss fraction, $\kappa_{DA}$ = density-altitude payload derate (Himalayan field elevations and temperatures), $\kappa_{\text{load}}$ = load-factor realization. Fleet dynamics mirror Eq. (4.3) with aircraft-specific attrition calibrated to ≈ 594 cumulative losses. **Validation anchor:** $A \approx 640$, $u \approx 0.9$, $\bar p_{\text{eff}} \approx 4$ t ⇒ ≈ 2,070 t/d, bracketing the attested July 1945 peak of ≈ 2,290 t/d.

### 4.5 Network Min-Cut (Bottleneck Identification)

$$C^{*}(t) \;=\; \min_{\Gamma \in \mathcal{C}} \sum_{e \in \Gamma} c_e(t)$$

over all cuts $\Gamma$ separating sources (ports) from sinks (Kunming complex), with edge capacities $c_e(t)$ drawn from P-16 through P-19 and the airlift module. The simulator should report $C^*(t)$ and the identity of the governing cut each tick — this reproduces the historical migration of the bottleneck from the Bengal–Assam Railway (1943–44) to the Hump/road interface (1945).

### 4.6 Tonnage-Allocation Program (The Political Core)

$$\max_{\{x_i\}} \sum_{i} w_i\, x_i(t)$$

subject to

$$\sum_i x_i(t) \;\le\; T_{\text{air}}(t) + T_{\text{eff}}(t) + T_{\text{pipe}}(t), \qquad l_i \;\le\; x_i(t) \;\le\; u_i,$$

$$S_i(t+1) \;=\; S_i(t) + x_i(t) - d_i(t) - \sigma S_i(t), \qquad S_i(t) \;\ge\; S_i^{\min}.$$

Indices $i$ ∈ {Fourteenth AF operations, B-29 Matterhorn support, Y-Force equipping, Z-Force training, ALPHA reserve}. Floors $l_i$ encode politically non-negotiable minimums (e.g., ALPHA reserve after the ICHIGO crisis); caps $u_i$ encode physical absorption limits; $\sigma$ = spoilage/pilferage rate; $S_i^{\min}$ = strategic reserve floor. Weights $w_i(t)$ are the *policy lever* through which conference decisions and command personalities enter the mathematics. **Representation:** weekly linear program; dual variables are logged as "political pressure" diagnostics.

### 4.7 Inflation-Adjusted Local Procurement

$$P(t+1) = P(t)\big(1+\pi(t)\big), \qquad C_{\text{loc}}(t) = \frac{q(t)\,P(t)}{e_{\text{off}}}, \qquad g(t) = \frac{e_{\text{bm}}(t)}{e_{\text{off}}}$$

with $P$ = local price index, $\pi(t)$ = inflation drift (P-30), $q$ = real quantity procured locally, $e_{\text{off}}$ = frozen official rate (P-28), $e_{\text{bm}}$ = free-market rate, $g(t)$ = arbitrage-gap diagnostic (P-29). Rising $g$ triggers the modeled behavioral responses: contractor flight from fabi-denominated contracts, in-kind settlement, and substitution of Hump-imported goods for local purchase — a feedback loop that *increased* airlift demand.

---

## 5. Compile-Safe Scala 3 Domain Model

```scala
package Logistics.ChinaLendLease

import java.time.LocalDate
import scala.collection.mutable.ListBuffer

/* ==========================================================================
 * Units of measure — opaque types for dimensional safety
 * ========================================================================== */

opaque type Tons = Double

object Tons:
  def apply(raw: Double): Tons =
    require(raw >= 0.0 && raw.isFinite, s"Tons must be finite and non-negative, got $raw")
    raw

  def zero: Tons = apply(0.0)

  extension (lhs: Tons)
    def +(rhs: Tons): Tons = lhs + rhs
    def -(rhs: Tons): Tons =
      val result = lhs - rhs
      require(result >= 0.0, "Tons subtraction produced a negative quantity")
      result
    def *(scale: Double): Tons = lhs * scale
    def per(days: Days): TonsPerDay = TonsPerDay(lhs / days.value)
    def value: Double = lhs

opaque type Days = Double

object Days:
  def apply(raw: Double): Days =
    require(raw >= 0.0 && raw.isFinite, s"Days must be finite and non-negative, got $raw")
    raw

  extension (lhs: Days)
    def +(rhs: Days): Days = lhs + rhs
    def /(rhs: Days): Double = lhs / rhs
    def *(scale: Double): Days = lhs * scale
    def value: Double = lhs

opaque type TonsPerDay = Double

object TonsPerDay:
  def apply(raw: Double): TonsPerDay =
    require(raw >= 0.0 && raw.isFinite, s"TonsPerDay must be finite and non-negative, got $raw")
    raw

  def zero: TonsPerDay = apply(0.0)

  extension (lhs: TonsPerDay)
    def +(rhs: TonsPerDay): TonsPerDay = lhs + rhs
    def *(scale: Double): TonsPerDay = lhs * scale
    def over(days: Days): Tons = Tons(lhs * days.value)
    def value: Double = lhs

opaque type Gallons = Double

object Gallons:
  def apply(raw: Double): Gallons =
    require(raw >= 0.0 && raw.isFinite, s"Gallons must be finite and non-negative, got $raw")
    raw

  extension (lhs: Gallons)
    def +(rhs: Gallons): Gallons = lhs + rhs
    def per(days: Days): GallonsPerDay = GallonsPerDay(lhs / days.value)
    def value: Double = lhs

opaque type GallonsPerDay = Double

object GallonsPerDay:
  def apply(raw: Double): GallonsPerDay =
    require(raw >= 0.0 && raw.isFinite, s"GallonsPerDay must be finite and non-negative, got $raw")
    raw

  extension (lhs: GallonsPerDay)
    def +(rhs: GallonsPerDay): GallonsPerDay = lhs + rhs
    def *(scale: Double): GallonsPerDay = lhs * scale
    def value: Double = lhs

/* ==========================================================================
 * Enumerated domain states
 * ========================================================================== */

enum Season(val throughputMultiplier: Double):
  case Dry        extends Season(1.00)
  case Transition extends Season(0.85)
  case Monsoon    extends Season(0.45)

enum SegmentClass(val baseSpeedMph: Double, val weatherSensitive: Boolean):
  case BroadGaugeRail         extends SegmentClass(20.0, false)
  case MeterGaugeRail         extends SegmentClass(12.0, false)
  case RiverFerry             extends SegmentClass(4.0, true)
  case EngineeredAllWeather   extends SegmentClass(14.0, true)
  case PrimitiveMountainTrack extends SegmentClass(8.0, true)
  case AirliftCorridor        extends SegmentClass(120.0, true)
  case PetroleumPipeline      extends SegmentClass(0.0, false)

enum Commodity:
  case DryCargo
  case BulkPetroleum
  case Ammunition
  case VehiclesAndParts
  case Rations

enum ConvoyPhase:
  case Loading
  case InTransit
  case HeldAtCongestion
  case Unloading
  case TurnaroundMaintenance

enum StockpileOutcome:
  case Accepted(levelAfter: Tons)
  case RejectedOverflow(rejected: Tons, capacity: Tons)
  case RejectedShortfall(requested: Tons, available: Tons)

/* ==========================================================================
 * Domain records with constructor validation
 * ========================================================================== */

final case class ConvoyParameters(trucks: Int, avgPayloadTons: Double, transitDays: Double):
  require(trucks > 0, s"trucks must be positive, got $trucks")
  require(
    avgPayloadTons > 0.0 && avgPayloadTons <= 12.0,
    s"implausible average payload: $avgPayloadTons"
  )
  require(
    transitDays > 0.0 && transitDays <= 60.0,
    s"implausible transit duration: $transitDays"
  )

final case class FleetPolicy(
  totalTrucks: Int,
  trucksPerConvoy: Int,
  dispatchIntervalDays: Double,
  mechanicalAvailability: Double
):
  require(totalTrucks > 0, "fleet size must be positive")
  require(
    trucksPerConvoy > 0 && trucksPerConvoy <= totalTrucks,
    "convoy size must be positive and not exceed fleet size"
  )
  require(dispatchIntervalDays > 0.0, "dispatch interval must be positive")
  require(
    mechanicalAvailability > 0.0 && mechanicalAvailability <= 1.0,
    "mechanical availability must lie in (0, 1]"
  )

final case class SegmentProfile(
  name: String,
  segmentClass: SegmentClass,
  lengthMiles: Double,
  baseTransitDays: Days,
  meanCongestionDelayDays: Days,
  hardCapacityTonsPerDay: TonsPerDay
):
  require(lengthMiles > 0.0, "segment length must be positive")
  require(hardCapacityTonsPerDay.value > 0.0, "hard capacity must be positive")

final case class ConvoyThroughputReport(
  grossTonsPerDay: TonsPerDay,
  seasonAdjustedTonsPerDay: TonsPerDay,
  fleetLimitedTonsPerDay: TonsPerDay,
  effectiveTonsPerDay: TonsPerDay,
  convoysInFlight: Int,
  cycleTimeDays: Days,
  governingConstraint: String
)

final case class EarthmovingPlant(
  dozers: Int,
  graders: Int,
  shovels: Int,
  gallPerDozerDay: Double,
  gallPerGraderDay: Double,
  gallPerShovelDay: Double
):
  require(dozers >= 0 && graders >= 0 && shovels >= 0, "machine counts must be non-negative")
  require(
    gallPerDozerDay >= 0.0 && gallPerGraderDay >= 0.0 && gallPerShovelDay >= 0.0,
    "burn rates must be non-negative"
  )

final case class MotorTransportPool(trucks: Int, gallPerTruckDay: Double):
  require(trucks >= 0, "truck count must be non-negative")
  require(gallPerTruckDay >= 0.0, "burn rate must be non-negative")

final case class AirliftFleet(
  c46Airframes: Int,
  c87Airframes: Int,
  c109Tankers: Int,
  sortiesPerAircraftDay: Double
):
  require(c46Airframes >= 0 && c87Airframes >= 0 && c109Tankers >= 0, "airframe counts must be non-negative")
  require(
    sortiesPerAircraftDay > 0.0 && sortiesPerAircraftDay <= 2.0,
    "sortie rate outside plausible band"
  )

final case class DemandClaim(
  consumer: String,
  requestedTonsPerDay: TonsPerDay,
  priorityWeight: Double,
  protectedFloorTonsPerDay: TonsPerDay
):
  require(priorityWeight >= 0.0, "priority weight must be non-negative")
  require(
    protectedFloorTonsPerDay.value <= requestedTonsPerDay.value,
    "protected floor cannot exceed the request"
  )

/* ==========================================================================
 * Core throughput kernels
 * ========================================================================== */

object RoadConvoyCapacity:

  def dailyCapacity(params: ConvoyParameters, dispatchIntervalDays: Double): Double =
    val totalTime = params.transitDays + dispatchIntervalDays
    if totalTime <= 0.0 then 0.0
    else (params.trucks.toDouble * params.avgPayloadTons) / totalTime

  def cycleTime(params: ConvoyParameters, dispatchIntervalDays: Double): Days =
    Days(params.transitDays + dispatchIntervalDays)

  def convoysInFlight(params: ConvoyParameters, dispatchIntervalDays: Double): Int =
    math.max(1, math.ceil(params.transitDays / dispatchIntervalDays).toInt)

  def fleetLimitedThroughput(fleet: FleetPolicy, params: ConvoyParameters): TonsPerDay =
    val availableTrucks = fleet.totalTrucks.toDouble * fleet.mechanicalAvailability
    val sustainableConvoys = math.floor(availableTrucks / fleet.trucksPerConvoy.toDouble)
    val simultaneousCeiling =
      convoysInFlight(params, fleet.dispatchIntervalDays).toDouble
    val convoysOnRoad = math.min(sustainableConvoys, simultaneousCeiling)
    val cycle = cycleTime(params, fleet.dispatchIntervalDays)
    TonsPerDay((convoysOnRoad * fleet.trucksPerConvoy * params.avgPayloadTons) / cycle.value)

  def seasonalThroughput(
    fleet: FleetPolicy,
    params: ConvoyParameters,
    season: Season,
    breakdownAttrition: Double = 0.02
  ): ConvoyThroughputReport =
    require(
      breakdownAttrition >= 0.0 && breakdownAttrition < 1.0,
      "breakdown attrition must lie in [0, 1)"
    )
    val gross = TonsPerDay(dailyCapacity(params, fleet.dispatchIntervalDays))
    val fleetCap = fleetLimitedThroughput(fleet, params)
    val governing =
      if gross.value <= fleetCap.value then "dispatch-interval cycle bound"
      else "fleet availability bound"
    val governed = if gross.value <= fleetCap.value then gross else fleetCap
    val seasonAdjusted = governed * season.throughputMultiplier
    val effective = seasonAdjusted * (1.0 - breakdownAttrition)
    ConvoyThroughputReport(
      grossTonsPerDay = gross,
      seasonAdjustedTonsPerDay = seasonAdjusted,
      fleetLimitedTonsPerDay = fleetCap,
      effectiveTonsPerDay = effective,
      convoysInFlight = convoysInFlight(params, fleet.dispatchIntervalDays),
      cycleTimeDays = cycleTime(params, fleet.dispatchIntervalDays),
      governingConstraint = governing
    )

/* ==========================================================================
 * Construction-fuel demand model (parameter P-25)
 * ========================================================================== */

object ConstructionFuelDemand:

  def dailyGallons(
    plant: EarthmovingPlant,
    transport: MotorTransportPool,
    auxiliaryGallonsPerDay: Double
  ): GallonsPerDay =
    require(auxiliaryGallonsPerDay >= 0.0, "auxiliary demand must be non-negative")
    val heavyPlant =
      plant.dozers * plant.gallPerDozerDay +
        plant.graders * plant.gallPerGraderDay +
        plant.shovels * plant.gallPerShovelDay
    val rollingFleet = transport.trucks * transport.gallPerTruckDay
    GallonsPerDay(heavyPlant + rollingFleet + auxiliaryGallonsPerDay)

  /** Reconstructed 1944 peak configuration on the Ledo front, per spec P-24. */
  val ledoPeak1944Plant: EarthmovingPlant =
    EarthmovingPlant(
      dozers = 300,
      graders = 150,
      shovels = 80,
      gallPerDozerDay = 45.0,
      gallPerGraderDay = 25.0,
      gallPerShovelDay = 40.0
    )

  val ledoPeak1944Transport: MotorTransportPool =
    MotorTransportPool(trucks = 2400, gallPerTruckDay = 9.0)

  val ledoPeak1944AuxiliaryGallonsPerDay: Double = 4000.0

  def ledoPeak1944Estimate: GallonsPerDay =
    dailyGallons(ledoPeak1944Plant, ledoPeak1944Transport, ledoPeak1944AuxiliaryGallonsPerDay)

/* ==========================================================================
 * Hump airlift module (equation 4.4)
 * ========================================================================== */

object HumpAirlift:

  val c46EffectivePayloadTons: Double = 3.6
  val c87EffectivePayloadTons: Double = 5.2
  val c109FuelLoadTonsEquivalent: Double = 8.4

  def dailyTonnage(fleet: AirliftFleet, densityAltitudeDerate: Double = 0.85): TonsPerDay =
    require(
      densityAltitudeDerate > 0.0 && densityAltitudeDerate <= 1.0,
      "density-altitude derate must lie in (0, 1]"
    )
    val totalAirframes = fleet.c46Airframes + fleet.c87Airframes + fleet.c109Tankers
    require(totalAirframes > 0, "airlift fleet cannot be empty")
    val weightedPayload =
      fleet.c46Airframes * c46EffectivePayloadTons +
        fleet.c87Airframes * c87EffectivePayloadTons +
        fleet.c109Tankers * c109FuelLoadTonsEquivalent
    val avgPayload = weightedPayload / totalAirframes.toDouble
    val dailySorties = totalAirframes.toDouble * fleet.sortiesPerAircraftDay
    TonsPerDay(dailySorties * avgPayload * densityAltitudeDerate)

/* ==========================================================================
 * Depot stockpile with bounded state transitions
 * ========================================================================== */

final class DepotStockpile(val name: String, val capacityTons: Tons, initialTons: Tons):
  require(initialTons.value <= capacityTons.value, "initial level exceeds capacity")
  private var level: Tons = initialTons

  def currentLevel: Tons = level

  def receive(inbound: Tons): StockpileOutcome =
    val space = capacityTons - level
    if inbound.value <= space.value then
      level = level + inbound
      StockpileOutcome.Accepted(level)
    else
      level = capacityTons
      StockpileOutcome.RejectedOverflow(inbound - space, capacityTons)

  def issue(requested: Tons): StockpileOutcome =
    if requested.value <= level.value then
      level = level - requested
      StockpileOutcome.Accepted(level)
    else
      StockpileOutcome.RejectedShortfall(requested, level)

/* ==========================================================================
 * Priority-floor allocation solver (discrete analogue of equation 4.6)
 * ========================================================================== */

object AllocationSolver:

  def allocate(supplyTonsPerDay: TonsPerDay, claims: List[DemandClaim]): Map[String, TonsPerDay] =
    val totalFloor = claims.map(_.protectedFloorTonsPerDay.value).sum
    val base: Map[String, TonsPerDay] =
      if totalFloor <= supplyTonsPerDay.value then
        claims.map(c => c.consumer -> c.protectedFloorTonsPerDay).toMap
      else
        claims
          .map(c =>
            c.consumer ->
              TonsPerDay(c.protectedFloorTonsPerDay.value * supplyTonsPerDay.value / totalFloor)
          )
          .toMap
    val committed = base.values.map(_.value).sum
    val remaining = TonsPerDay(math.max(0.0, supplyTonsPerDay.value - committed))
    val eligible = claims.filter(c => c.requestedTonsPerDay.value > base(c.consumer).value)
    val weightSum = eligible.map(_.priorityWeight).sum
    if weightSum <= 0.0 || remaining.value <= 0.0 then base
    else
      val grants = eligible.map { c =>
        val need = c.requestedTonsPerDay.value - base(c.consumer).value
        c.consumer -> math.min(need, remaining.value * c.priorityWeight / weightSum)
      }
      grants.foldLeft(base) { case (accumulator, (consumer, extra)) =>
        accumulator.updated(consumer, TonsPerDay(accumulator(consumer).value + extra))
      }

/* ==========================================================================
 * Attested and reconstructed historical constants (spec section 2)
 * ========================================================================== */

object HistoricalConstants:
  val firstConvoyDepartureLedo: LocalDate = LocalDate.of(1945, 1, 12)
  val firstConvoyArrivalKunming: LocalDate = LocalDate.of(1945, 2, 4)
  val stilwellRoadLengthMiles: Double = 1079.0
  val newConstructionMilesLedoToMongYu: Double = 466.0
  val humpTonnageCalendar1944: Tons = Tons(251000.0)
  val humpTonnageJanJul1945: Tons = Tons(366700.0)
  val humpPeakMonthlyTonnageJul1945: Tons = Tons(71042.0)
  val estimatedRoadCumulativeTonnageFebAug1945: Tons = Tons(35000.0)
  val estimatedPipelineCumulativeTonnageToVJDay: Tons = Tons(25000.0)
  val lendLeaseDollarValueChinaTotal: Double = 845700000.0
  val constructionFuelEstimateGallonsPerDay: GallonsPerDay =
    ConstructionFuelDemand.ledoPeak1944Estimate
  val officialExchangeRateFabiPerUsd: Double = 20.0
  val estimatedBlackMarketFabiPerUsdMid1945: Double = 1000.0

/* ==========================================================================
 * Validation suite
 * ========================================================================== */

object ValidationChecks:

  def validateConvoyPlan(
    fleet: FleetPolicy,
    params: ConvoyParameters,
    season: Season
  ): List[String] =
    val report = RoadConvoyCapacity.seasonalThroughput(fleet, params, season)
    val issues = ListBuffer.empty[String]
    if report.effectiveTonsPerDay.value <= 0.0 then
      issues += "Effective throughput collapsed to zero"
    if report.convoysInFlight * params.trucks > fleet.totalTrucks then
      issues += "Simultaneous convoys exceed the available motor fleet"
    if params.avgPayloadTons > 2.5 then
      issues += "Payload exceeds the nominal 2.5-ton CCKW rating; verify trailer augmentation"
    if report.cycleTimeDays.value > 14.0 then
      issues += "Cycle time exceeds 14 days; inspect segment congestion delays"
    issues.toList

/* ==========================================================================
 * Demonstration harness (fully implemented, no placeholders)
 * ========================================================================== */

object SimulationDemo:

  def headlineFigures: String =
    val fleet = FleetPolicy(
      totalTrucks = 2000,
      trucksPerConvoy = 200,
      dispatchIntervalDays = 1.0,
      mechanicalAvailability = 0.72
    )
    val params = ConvoyParameters(trucks = 200, avgPayloadTons = 2.2, transitDays = 6.0)
    val dry = RoadConvoyCapacity.seasonalThroughput(fleet, params, Season.Dry)
    val wet = RoadConvoyCapacity.seasonalThroughput(fleet, params, Season.Monsoon)
    val fuel = ConstructionFuelDemand.ledoPeak1944Estimate
    s"Stilwell Road dry-season effective: ${dry.effectiveTonsPerDay.value.round} t/d; " +
      s"monsoon: ${wet.effectiveTonsPerDay.value.round} t/d; " +
      s"governing constraint: ${dry.governingConstraint}; " +
      s"construction POL demand estimate: ${fuel.value.round} gal/d"

  def kunmingStockpileWalkthrough: String =
    val depot = DepotStockpile("Kunming Main", Tons(60000.0), Tons(12000.0))
    val afterReceipt = depot.receive(Tons(25000.0))
    val afterIssue = depot.issue(Tons(20000.0))
    s"After receipt: ${afterReceipt.toString}; after issue: ${afterIssue.toString}"
```

---

## 6. Graduate-Level Operational Analysis

### 6.1 Why Did the Stilwell Road Open So Late — and Was It Worth It?

**The lateness was overdetermined by five interacting causes, only one of which was engineering.**

First, *strategic priority churn*. The road was a child of the 1942 disaster: after Rangoon fell and Burma was lost by May 1942, the overland route existed only as intention. Casablanca (January 1943) endorsed its recovery, but every subsequent global allocation cycle — the Sicilian and Italian commitments, the buildup for OVERLORD, the Pacific central-axis advances — outranked it in the Combined Chiefs' economy of force. The decisive wound was self-inflicted at SEXTANT: the promise of BUCANEER was the political price of Chiang's Y-Force commitment, and when the assault shipping was redirected to Anzio and Normandy, the entire 1944 Burma timetable slipped and Chinese cooperation with it. A road project dependent on a fragile coalition bargain inherits that bargain's fragility.

Second, *the climatic clock*. Northern Burma permits heavy earthmoving essentially only from October to May. Each missed dry season cost a year; the project consumed precisely three of them (1942–43 reconnaissance and pioneer work, 1943–44 Pick's main drive, 1944–45 completion), and the middle season was largely sacrificed to the Japanese HA-GO/U-GO offensives in Arakan and at Imphal, which pulled engineering and transport assets into defensive logistics.

Third, *the Myitkyina prerequisite*. The route's centerline ran through the Mogaung valley; until Merrill's Marauders and the X-Force seized the airfield (May 1944) and the town (August 1944), construction south of Shingbwiyang proceeded under interdiction threat and the Hump could not exploit the shortened corridor. The road's schedule was thus hostage to a siege conducted by forces who themselves had to be supplied by air.

Fourth, *ICHIGO*. From April 1944 the Japanese offensive in eastern China destroyed the operational rationale timeline: airfields the road was meant to sustain were being overrun even as the road advanced, and U.S. effort pivoted to the ALPHA emergency.

Fifth, *engineering reality*. Pick inherited a stalled project in October 1943 and imposed industrial discipline — but 466 miles of new alignment through jungle, over the Pangsau Pass, across a dozen major river crossings, in malaria country that hospitalized engineers faster than combat units in Italy, was simply a multi-season task. Roughly 15,000 American engineers and 35,000 laborers, ~$140 million, and over a thousand American dead bought 466 miles.

**Was it worth it?** As a pure transport investment, modern analysis says no, and the arithmetic is unforgiving. The road moved on the order of 5,000 tons per month for seven months — call it 35,000–50,000 tons — against a Hump delivering 71,042 tons in July 1945 alone. Capital cost per delivered ton over the road's life runs to thousands of dollars per ton before operating expenses, versus Hump costs in the low hundreds. The opportunity-cost column is worse: those engineer regiments and that shipping had competing employments in the European port-clearance program whose shortfalls (Antwerp's delayed opening, Cherbourg's slow clearance) measurably slowed the Allied advance in 1944.

Yet three defenses survive rigorous scrutiny. (i) *Option value under uncertainty*: in 1943 no planner could guarantee that the Hump — dependent on a handful of Assam airfields, weather-plagued, and within range of any competent Japanese interdiction effort — would scale to 60,000+ tons per month. A ground line of communication was rational portfolio diversification; its realized payoff was low because the correlated risk (Hump failure) failed to materialize. Insurance that is not needed looks wasteful ex post by construction. (ii) *System enablement*: the road carried the pipeline, and the road's clearing campaigns (X-Force, Y-Force) seized the Myitkyina fields that materially expanded the airlift; the modes were complements, not substitutes. (iii) *Political function*: the road was the only promise made to Chiang in 1942 that was ultimately kept in physical form, and its ceremonial arrival in Kunming — 113 vehicles, February 4, 1945 — purchased coalition cohesion at a moment when the alternative was Chinese collapse or separate peace speculation. The mature verdict: an ex-ante-defensible hedge executed at ex-post-inefficient scale — a triumph of American engineering capability serving a strategy that capability could not rescue.

### 6.2 Chinese Currency Inflation and U.S. Local Procurement

The fabi's collapse was not a background nuisance; it was a second logistics system running in parallel with the physical one, and it degraded both. Free China financed the war predominantly through note-issue: with the industrial and customs base of the eastern provinces lost, tax receipts covered a trivial fraction of expenditure, and the government levied an inflation tax on its own population. The Chungking wholesale index rose by roughly an order of magnitude every eighteen months through 1943–45; the $500 million U.S. stabilization loan of February 1942, intended to back the currency, was dissipated into ordinary expenditure by 1944; and the official exchange rate froze at 20 fabi per U.S. dollar while the free-market rate diverged by one order of magnitude in 1944 and approached two by mid-1945.

For U.S. Army logistics, four mechanisms mattered. **(1) Real-resource extraction masked as accounting.** Dollar-denominated budgets converted at the official rate systematically understated the real resources the theater extracted: when SOS hired hundreds of thousands of laborers — the Chengtu B-29 base construction alone employed on the order of 300,000 — the fabi wages paid were purchasing power freshly created against a fixed local food and cloth supply, so each U.S. construction project accelerated the very inflation that raised its next quarter's costs. The simulator must model local procurement as a *real-resource draw* with a price-elastic supply curve, not as a dollar expense line. **(2) Contractual flight and in-kind settlement.** As the fabi's expected-value decay outpaced contracting cycles, Chinese suppliers and labor brokers refused fabi terms; U.S. buyers shifted to commodity barter (rice, cloth, silver coins), spot dollar payments, and requisition-with-receipt arrangements — each with distinct corruption and accounting signatures that the model should carry as separate transaction types. **(3) The arbitrage gap as a corruption gradient.** With $1 officially worth 20 fabi and privately worth twenty times that, every dollar-flowing channel — paymasters, procurement officers, Lend-Lease warehouses — developed leakage. Pilferage of truck fuel and cargo along the road and at Kunming was partly an arbitrage phenomenon, and belongs in the model as a rate proportional to $g(t) = e_{bm}/e_{off}$. **(4) The substitution feedback loop.** As local markets failed, the theater imported by air items that were locally producible in principle — rations, construction materials, even currency itself: the Treasury's gold-flighting program (roughly $200 million delivered by V-J Day) consumed scarce Hump lift to move a monetary stabilizer, a striking case of logistics capacity being spent on the financial layer of the war. Each substitution raised Hump demand, which raised competition for tonnage, which raised the shadow price of every allocation-board decision.

The deeper lesson for the simulation engine is that **nominal and real ledgers must be separated**. The U.S. Army could always print or wire dollars; it could not print rice, porters, or cartage animals. Inflation determined the *distribution* of the real burden — onto Chinese peasants, soldiers whose pay became worthless, and contractors — and thereby shaped labor supply, pilferage rates, and coalition trust, all of which fed back into physical throughput. A faithful Chapter 29 model therefore couples the Eq. (4.7) price process directly into the labor-supply and attrition coefficients of the physical network, closing the loop between the financial and material pipelines that the historical actors themselves never fully managed to sever.
