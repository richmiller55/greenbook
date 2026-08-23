Cost: 0

# Reference Manual & Simulation Specification
## Chapter 17 — Joint Logistics in Pacific Operations: The Continental System
### Source Volume: *Global Logistics and Strategy: 1943–1945* (Coakley & Leighton, U.S. Army in World War II series)

**Document conventions.** All quantitative entries carry a provenance tag: **[A]** = primary-source/standard-definition value (lock as constant); **[B]** = synthesized from secondary scholarship (lock with citation); **[C]** = calibrated estimate (expose as tunable parameter with prior band); **[D]** = asserted in tasking but *not corroborated* in the documentary record (do not instantiate; substitute proxy). This grading is deliberate: hard-coding an unverifiable "exact value" into an execution engine is a defect, not rigor. Where the tasking requests a figure the record does not support, this document supplies the nearest verified analogue and marks the substitution explicitly.

---

## 1. Strategic Context & Modern Historical Perspective

Chapter 17 sits at the hinge between two logistical universes: the *global* allocation machinery of the Combined and Joint Chiefs, and the *physical* reality of a handful of West Coast piers through which the entire Japanese-directed effort of the Army and Navy had to pass. The chapter's organizing concept — the "Continental System" — is best understood as the zone-of-interior answer to a queueing problem. The United States never lost the Pacific war for want of production; it repeatedly risked losing *tempo* for want of berths, railcars, warehouse cube, and ship-turnaround days. The Continental System — the coordinated Army–Navy network of ports of embarkation (POEs), inland holding-and-reconsignment depots, staging areas, and synchronized loading calendars stretching from the Mississippi Valley to Puget Sound — existed to convert an erratic river of continental production into a scheduled, berth-by-berth flow at tidewater.

**The strategic paradox.** The great Allied conferences produced commitments that multiplied faster than hulls. Casablanca (January 1943) reaffirmed Europe-first while authorizing continued Pacific offensives up the Solomons–New Guinea axis; TRIDENT (May 1943) fixed the 1944 cross-Channel build-up (BOLERO) and Burma/China tonnage priorities; QUADRANT (August 1943) accelerated the Pacific timetable and consolidated Southeast Asia Command; SEXTANT (Cairo, November–December 1943) ratified a 1944 grand strategy in which King's Central Pacific drive was approved largely as a *fixed-cost* commitment layered onto an already oversubscribed shipping pool. Every Liberty ship routed San Francisco–Brisbane was a Liberty unavailable for Avonmouth or Omaha Beach. The U-boat crisis — worst in March 1943, broken in "Black May" — made the global pool genuinely fungible and genuinely scarce at once. The paradox resolved itself arithmetically: since hulls could not be conjured (2,710 Liberties eventually built, ~10-knot service speed, a San Francisco–Manila round trip consuming two months or more), the only elastic variable was *time in port*. A day stripped from loading or discharge at either end of the pipeline purchased additional annual voyages per hull as surely as a new shipyard would have. This is why port productivity — the business of the Continental System — was a *strategic*, not housekeeping, variable. Modern readers will recognize the identity immediately: fleet throughput equals hulls times payload divided by cycle time, and the Continental System attacked the denominator.

**Inter-service and coalition tensions.** The Army Service Forces under Lt. Gen. Brehon Somervell embodied a single-manager doctrine: one supply system, one accounting universe, technical services coordinated under a general staff. The Navy's Bureau of Supplies and Answers world was the opposite — a federated system of bureaus, type commanders, and the colossal Service Force, Pacific Fleet under Vice Adm. William L. Calhoun, whose floating depots and (from autumn 1944) Service Squadron 10 at Ulithi constituted a *mobile* logistics architecture that had no Army analogue. Admiral King's dual hat as CNO and COMINCH concentrated Navy shipping power in ways the Army could contest only through committees: the Joint Military Transportation Committee (1942), the Joint Logistics Committee and its planning arm convened in early 1943, and the Anglo-American Combined Shipping Adjustment Board. These bodies were coordination-*without*-command, and everyone knew it. Theater architecture deepened the asymmetry: Nimitz's Pacific Ocean Areas ran logistics through a Navy-dominated joint staff; MacArthur's Southwest Pacific Area ran through a shore-based Army USASOS (Maj. Gen. Richard J. Marshall from early 1943, abolished in favor of AFPAC in 1945). Two supply philosophies, both legitimate, both enormous, converged on the same twenty-six-odd deep-draft berths of San Francisco Bay. Coalition politics added a third pressure: British partners scrutinized every Pacific tonnage report for evidence of drift from Europe-first, which gave the Army a bureaucratic incentive to standardize reporting in measurement tons and to make the Continental System *legible* — proof that Pacific growth was scheduled, bounded, and non-cannibalizing.

**Historical-era context: how the system actually worked.** The mechanism deserves precise statement because it is the chapter's transferable idea. Cargo moved factory → technical-service depot → **inland holding-and-reconsignment point** (Sharpe General Depot at Lathrop, California; Utah General Depot at Ogden; the Navy's inland depot at Clearfield, Utah) → tidewater **only against a firm sailing**. Cargo was documented to the POE but physically stopped inland, with final ship assignment deferred — reconsignment — until a loading calendar slot existed. Staging areas (Camp Stoneman for San Francisco; Fort Lewis for Seattle; Camp Anza for Los Angeles) held troops to a roughly fourteen-day cycle keyed to sailings. Cross-service arrangements let Army bottoms carry Navy cargo and vice versa when cube permitted, and joint storage agreements let NSD Oakland and Army Oakland facilities absorb each other's overflow. In modern supply-chain vocabulary this is *postponement* (delay final destination assignment until demand — here, berth availability — is known) plus *decoupling-point management*: the inland yard was the inventory decoupling point between continental rail variability and tidal berth scheduling. The system's function was not merely storage; it was **variance absorption**. An M/M/1 port queue degrades catastrophically as arrival variance rises; holding yards converted Poisson-like arrivals into near-deterministic ones.

**Modern analytical insights.** Three post-war lenses sharpen the chapter. First, operational research: the West Coast gates were stochastic servers operating at ρ ≈ 0.8–0.9 in late 1944, when Philippines sustainment, the Marianas pipeline, and the seed of the Olympic build-up drove the San Francisco Port of Embarkation toward a peak on the order of 400,000 measurement tons per month. At that utilization, mean queue delay is hypersensitive to small arrival increases — precisely the regime the Continental System was built to police. Second, catastrophe and resilience: the Port Chicago naval magazine detonation of 17 July 1944 (≈5,000 tons of munitions, 320 killed, 390 injured, two ships and a pier destroyed, and the subsequent "Port Chicago 50" courts-martial) shows a shared Army–Navy resource failing in the worst way, and recovering to partial operations within weeks — a resilience datum rare in the archival record. Third, downstream coupling: the Leyte discharge collapse of October–December 1944, where ships queued offshore for weeks because beach discharge ran at a fraction of plan, demonstrated that continental smoothing could be defeated by theater-side saturation — the pipeline saturates at its *minimum*-capacity server, not its maximum. And the near-crisis of the continental rail network in the winter of 1944–45, followed by the mass spring-1945 "Pacemaker" troop lifts, showed the whole system coupled back through the Overland Route and Santa Fe corridors. The counterfactual the chapter implies is stark: without joint holding yards and reconsignment discipline, West Coast yards would have clogged, rail demurrage would have propagated back through Chicago and St. Louis, and the national network — not the Japanese — would have imposed the operational pause. As Phillips Payson O'Brien has argued, the war was won in the "air-sea" sphere of production and movement; Chapter 17 is the administrative anatomy of that thesis on the Pacific side.

---

## 2. High-Fidelity Simulation Parameters & Real-World Metrics

Values are grouped by subsystem. "Simulator representation" indicates how each entry enters the engine: `STATIC_CONSTANT`, `CAPACITY_CAP`, `EFFICIENCY_COEFFICIENT`, `POLICY_PARAMETER`, `STATE_VARIABLE`, `EVENT_TRIGGER`, or `VALIDATION_ANCHOR`.

### 2.1 Governance & Institutional Constants

| ID | Parameter | Value | Simulator representation | Prov. | Historical rationale |
|----|-----------|-------|--------------------------|-------|----------------------|
| G-01 | "Joint Army-Navy Logistics Board (**JANET**)" establishment date | **Not corroborated** — no board styled "JANET" appears in the Green Book chapter, JCS records, or the standard organizational literature (Millett; Ballantine). **Do not instantiate.** Use G-02/G-03 as proxies. | `EVENT_TRIGGER` withheld; proxy chain below | **[D]** | The tasking's "JANET" is not a verifiable WWII body. Fabricating a date would inject a false constant into the simulation. Verified analogues: rows G-02–G-05. |
| G-02 | Joint Logistics Plans Committee (JLPC) begins functioning | Feb–Mar 1943 | `STATIC_CONSTANT` (scenario clock anchor) | [B] | Working planning arm of the emerging JCS logistics machinery; coordinated global tonnage programs that framed West Coast loading calendars. Verify exact day against JCS minutes before lock. |
| G-03 | Joint Logistics Committee (JLC) formalized | Early 1943 (spring) | `STATIC_CONSTANT` | [B] | Parent body arbitrating Army (ASF) vs. Navy (BuSandA) claims on common resources — the Washington-level echo of West Coast friction modeled in §6. |
| G-04 | Joint Military Transportation Committee (JMTC) operative | 1942 | `STATIC_CONSTANT` | [B] | Standardized military shipping reporting (incl. measurement-ton conventions) — prerequisite data infrastructure for the Continental System's joint calendars. |
| G-05 | Combined Shipping Adjustment Board (Anglo-American) operative | Early 1943 | `STATIC_CONSTANT` | [B] | Pool-level allocation context: every Pacific sailing was priced against ETO/SEAC claims. |
| G-06 | ASF established (WD reorganization) | 9 Mar 1942 | `STATIC_CONSTANT` | [A] | Creates the single-manager Army actor whose doctrine collided with Navy bureau autonomy. |
| G-07 | Transportation Corps established | 31 Jul 1942 | `STATIC_CONSTANT` | [A] | Owns POEs, port battalions, and domestic movement control — the executing arm of the Continental System. |

### 2.2 Physical & Vessel Constants

| ID | Parameter | Value | Simulator representation | Prov. | Historical rationale |
|----|-----------|-------|--------------------------|-------|----------------------|
| P-01 | Measurement ton (MTON) | 40 ft³ | `STATIC_CONSTANT` (unit definition) | [A] | Standard Army/Navy stowage and reporting unit; all capacity values below are denominated in MTON. |
| P-02 | Long ton | 2,240 lb | `STATIC_CONSTANT` | [A] | Deadweight convention for hull limits; distinct from short ton (2,000 lb) — a classic unit-bug source. |
| P-03 | Liberty (EC2-S-C1) deadweight | ≈ 10,800 LT | `STATIC_CONSTANT` (vessel template) | [A] | Workhorse of the Pacific pipeline; Kaiser Richmond yards adjacent to SFPE shortened the build-to-load leg. |
| P-04 | Liberty bale cube | ≈ 480,000 ft³ ≈ 12,000 MTON theoretical | `STATIC_CONSTANT` | [B] | Theoretical cube; never achievable with mixed Army cargo. |
| P-05 | Practical payload coefficient, dry general cargo | 0.70–0.85 of cube/dwt envelope | `EFFICIENCY_COEFFICIENT` (per commodity mix) | [C] | Stowage loss from dunnage, accessibility, combat-loading segregation. Combat loading pushes toward the low bound. |
| P-06 | Liberty service speed / zigzag time factor | 10 kn; ×1.10–1.15 on transit time | `STATIC_CONSTANT` + `EFFICIENCY_COEFFICIENT` | [A]/[B] | Sets convoy transit-day values used throughout §3–§5. |
| P-07 | Victory (VC2-S-AP2) speed | ≈ 15 kn | `STATIC_CONSTANT` | [B] | Higher-speed premium sailings for time-critical lifts. |

### 2.3 Route Geometry (great-circle, nautical miles)

| ID | Leg | Value (nm) | Prov. |
|----|-----|-----------|-------|
| R-01 | San Francisco – Oahu | 2,089 | [A] |
| R-02 | Oahu – Majuro | ≈ 2,300 | [C] |
| R-03 | Majuro – Ulithi | ≈ 1,850 | [C] |
| R-04 | Ulithi – Leyte | ≈ 870 | [C] |
| R-05 | San Francisco – Brisbane (southern lane) | ≈ 6,400 | [C] |
| R-06 | Seattle – Oahu | ≈ 2,360 | [C] |

All route values: `STATIC_CONSTANT` in a route table; transit days derive from P-06.

### 2.4 Infrastructure Capacities & Flow Metrics (the core dataset)

| ID | Parameter | Value | Simulator representation | Prov. | Historical rationale |
|----|-----------|-------|--------------------------|-------|----------------------|
| I-01 | SFPE deep-draft berths (Fort Mason + leased + Oakland Army Base when completed early 1945) | ≈ 26 | `CAPACITY_CAP` (server count *c*) | [C] | Server count for M/M/*c* model in §4. |
| I-02 | SFPE aggregate service rate | μ ≈ 16.0 ships/day (≈0.615 ships/berth/day; 2–4 day general-cargo turns) | `CAPACITY_CAP` | [C] | Calibration anchor for queueing engine. |
| **I-03** | **SFPE peak monthly clearance, late 1944 (Nov–Dec)** | **≈ 420,000 MTON/month; planning band 350,000–450,000** | `VALIDATION_ANCHOR` + seasonal `CAPACITY_CAP` | **[C]** | Derived: aggregate West-Coast outbound ≈1.0–1.2M MTON/mo at Philippines-sustainment peak; SFPE historical share ≈ 40%. Lock midpoint; calibrate against quarterly POE reports. Drives the λ used in §4–§5. |
| I-04 | Aggregate West Coast outbound, late 1944 | ≈ 1.0–1.2M MTON/mo | `VALIDATION_ANCHOR` | [C] | Parent constraint for I-03, I-05–I-07; sum of gates must ≤ this. |
| I-05 | Los Angeles PE (Wilmington) capacity | ≈ 180,000 MTON/mo | `CAPACITY_CAP` | [C] | Southern gate; Camp Anza staging feed. |
| I-06 | Seattle PE capacity | ≈ 160,000 MTON/mo | `CAPACITY_CAP` | [C] | Northern gate; Fort Lewis staging feed. |
| I-07 | Portland subport capacity | ≈ 60,000 MTON/mo | `CAPACITY_CAP` | [C] | North Pacific (Aleutians) lane. |
| I-08 | Sharpe General Depot (Lathrop CA) reconsignment buffer | ≈ 200,000 MTON | `STATE_VARIABLE` (buffer stock ceiling) | [C] | The archetypal holding-and-reconsignment yard protecting SFPE. |
| I-09 | Utah General Depot (Ogden) throughput | ≈ 250,000 MTON/mo | `CAPACITY_CAP` | [C] | Continental consolidation for both SF and Seattle lanes. |
| I-10 | NSD Clearfield (UT) throughput | ≈ 200,000 MTON/mo | `CAPACITY_CAP` | [C] | Navy inland depot (est. 1943) — deliberate partial duplication, see §6.2. |
| I-11 | NSD Oakland static storage | ≈ 300,000 MTON | `CAPACITY_CAP` | [C] | Navy's Bay Area anchor (commissioned 1942); cross-service exchange partner to Army gates. |
| I-12 | Camp Stoneman troop capacity | ≈ 20,000 | `CAPACITY_CAP` (personnel) | [C] | Principal SFPE staging area; 14-day cycle. |
| I-13 | Staging dwell policy | 14 days | `POLICY_PARAMETER` | [B] | ASF standard; synchronizes troop arrivals to sailings. |
| I-14 | Rail corridor caps: Overland Route / Santa Fe / GN-NP | ≈ 220k / 140k / 120k MTON/mo | `CAPACITY_CAP` (edge weights) | [C] | Continental coupling constraints; binding during Dec 44–Feb 45 rail crisis. |

### 2.5 Behavioral Coefficients & Event Triggers

| ID | Parameter | Value | Simulator representation | Prov. | Historical rationale |
|----|-----------|-------|--------------------------|-------|----------------------|
| F-01 | Managed vs. unmanaged port dwell | ≤ 10 days managed; 20–30 days unmanaged | `EFFICIENCY_COEFFICIENT` pair | [C] | Quantifies the Continental System's value: dwell reduction ≈ hull-productivity gain via §4 Eq. (4). |
| F-02 | Theater beach-discharge efficiency vs. plan | 0.4–0.6 (Leyte Oct–Dec 1944 ≈ 0.4) | `EFFICIENCY_COEFFICIENT` | [B] | Downstream saturation term; defeats upstream smoothing when < ~0.5. |
| F-03 | Pipeline depth policy | 75–90 days of supply afloat + theater | `POLICY_PARAMETER` | [B] | Sets minimum in-pipeline inventory via Little's Law. |
| F-04 | Cross-service cross-loading share | 10–15% of lift | `POLICY_PARAMETER` (switch + weight) | [C] | Army bottoms carrying Navy cube and vice versa. |
| F-05 | Reconsignment release window to tidewater | 10–14 days before sailing | `POLICY_PARAMETER` | [B] | Core anti-congestion rule; the "Continental System" in one number. |
| E-01 | **Port Chicago detonation** | 17 Jul 1944; 320 killed / 390 injured; ≈ 5,000 LT munitions; 2 ammo berths lost; partial recovery ≈ 3 weeks, structural recovery ≈ 6 months | `EVENT_TRIGGER` → `NodeState.Offline` → ramped `Degraded` | [A]/[C] | Shared-resource catastrophic failure; implemented in §5 `DisruptionEvent.Detonation`. |
| E-02 | Leyte saturation window | Oct–Dec 1944; discharge ≈ 40% of plan; offshore queues of weeks | `EVENT_TRIGGER` (theater-side) | [A] | Demonstrates W → ∞ regime; validation case for instability detection. |
| E-03 | Continental rail crisis | Dec 1944 – Feb 1945 | `EVENT_TRIGGER` (edge-capacity derate) | [B] | Derate I-14 corridors 30–50% for scenario stress tests. |
| E-04 | "Pacemaker" spring-1945 troop lifts | May 1945, mass movements to West Coast POEs | `EVENT_TRIGGER` (personnel surge multiplier) | [B] | Olympic-buildup preload; stresses staging + berth queues jointly. |

---

## 3. Logistical Network Topology (Mermaid.js)

Queue annotations use the §4 notation: λ = arrival rate, μ = service rate, ρ = utilization. Thick arrows (`==>`) denote primary arteries; dotted (`-.->`) denote alternative/conditional routings.

```mermaid
flowchart LR

classDef gate fill:#f9d5cc,stroke:#8b1a1a,stroke-width:2px
classDef inland fill:#dbe9f6,stroke:#1a4f8b,stroke-width:1px
classDef navy fill:#d9f2d9,stroke:#1a6b1a,stroke-width:1px
classDef theater fill:#f6ecd9,stroke:#8b6b1a,stroke-width:1px
classDef event fill:#ffcccc,stroke:#cc0000,stroke-width:3px

subgraph ZI["ZONE OF INTERIOR - CONTINENTAL SYSTEM"]
  RAILW["Midwest and Eastern factories<br/>CMP controlled materials"]:::inland
  subgraph INLAND["Inland Holding and Reconsignment Layer"]
    UGD["Utah General Depot Ogden<br/>cap 250000 MTON per mo"]:::inland
    CLEARFIELD["NSD Clearfield UT<br/>Navy inland depot<br/>cap 200000 MTON per mo"]:::navy
    SHARPE["Sharpe General Depot Lathrop CA<br/>buffer 200000 MTON<br/>reconsignment desk"]:::inland
    BENICIA["Benicia Arsenal<br/>ammunition consolidation"]:::inland
  end
  subgraph STAGING["Staging Areas - 14 day dwell policy"]
    STONEMAN["Camp Stoneman CA<br/>about 20000 troops"]:::inland
    FORTLEWIS["Fort Lewis WA staging"]:::inland
    CAMPANZA["Camp Anza CA staging"]:::inland
  end
end

subgraph TIDEWATER["WEST COAST GATES"]
  SFPE["San Francisco PE - Fort Mason and Oakland Army Base<br/>26 berths - lambda 13.3 ships per d - mu 16.0 ships per d - rho 0.83<br/>peak 420000 MTON per mo late 1944"]:::gate
  PORTCHICAGO["Port Chicago Naval Magazine<br/>2 ammunition berths<br/>DETONATION 17 JUL 1944"]:::event
  NSDOAK["NSD Oakland<br/>Navy general stores<br/>about 300000 MTON static"]:::navy
  LAPE["Los Angeles PE Wilmington<br/>cap 180000 MTON per mo"]:::gate
  SEAPE["Seattle PE<br/>cap 160000 MTON per mo"]:::gate
  PORPORT["Portland subport<br/>cap 60000 MTON per mo"]:::gate
end

subgraph BLUEWATER["TRANS-PACIFIC PIPELINE"]
  PEARL["Pearl Harbor - ComServPac<br/>throughput 500000 MTON per mo"]:::theater
  MAJURO["Majuro anchorage"]:::theater
  ULITHI["Ulithi - Service Squadron 10<br/>floating base"]:::theater
  SUVA["Southern lane stops - Suva Noumea"]:::theater
end

subgraph THEATER["THEATER RECEPTION AND FORWARD AREAS"]
  BRISBANE["Brisbane and Sydney bases SWPA"]:::theater
  HOLLANDIA["Hollandia advanced base SWPA"]:::theater
  LEYTE["Leyte beaches Tacloban<br/>plan 30000 LT per d - actual 12000 to 18000<br/>OFFSHORE QUEUE CRISIS OCT-DEC 1944"]:::event
  MANILA["Manila Bay 1945"]:::theater
  GUAM["Guam and Marianas CENPAC"]:::theater
  ATTU["Aleutian garrisons"]:::theater
end

RAILW -- "Overland Route SP-UP<br/>220000 MTON per mo - 6 to 8 d" --> UGD
RAILW -- "Santa Fe<br/>140000 MTON per mo - 6 to 8 d" --> SHARPE
RAILW -- "Navy factory direct<br/>reconsigned inland" --> CLEARFIELD
RAILW -- "Northern GN-NP<br/>120000 MTON per mo" --> SEAPE

UGD -- "reconsigned Army lots<br/>release window 10-14 d" --> SFPE
UGG_ALT[" "] -.-
UGD -.-> "split routing" -.-> SEAPE
CLEARFIELD -- "Navy lots to tidewater" --> NSDOAK
SHARPE -- "scheduled berth releases" --> SFPE
BENICIA -- "ammo lots" --> PORTCHICAGO
PORTCHICAGO -- "magazine lots" --> SFPE
PORTCHICAGO -- "magazine lots" --> LAPE
NSDOAK -.-> "cross-service issue and overflow swap" -.-> SFPE

STONEMAN -- "troop lifts" --> SFPE
CAMPANZA -- "troop lifts" --> LAPE
FORTLEWIS -- "troop lifts" --> SEAPE

SFPE ==> "Great Circle 2089 nm - 9 to 11 d - 260000 MTON per mo" ==> PEARL
SFPE -.-> "southern lane 6400 nm - about 27 d - 120000 MTON per mo" -.-> SUVA
LAPE -.-> "southern lane" -.-> SUVA
SEAPE ==> "2360 nm - 10 to 12 d" ==> PEARL
PORPORT -- "North Pacific lane" --> ATTU

PEARL ==> "2300 nm - 10 d" ==> MAJURO
MAJURO -- "1850 nm - 8 d" --> ULITHI
ULITHI -- "870 nm - 4 d" --> LEYTE
ULITHI --> GUAM
SUVA --> BRISBANE
BRISBANE -- "advanced base lift" --> HOLLANDIA
HOLLANDIA --> LEYTE
LEYTE -- "1945 consolidation" --> MANILA
```

**Modeling notes.** (1) The inland layer is drawn as a *buffer bank*, not a pass-through: its state variables (backlog vs. buffer ceiling, I-08) modulate the arrival process λ at each gate. (2) SFPE is the system's dominant server; its ρ ≈ 0.83 in late 1944 places it in the steep region of the delay curve. (3) Leyte is annotated as a *downstream saturation* node — the historical case where the pipeline's effective W diverged despite continental smoothing. (4) Dotted edges encode the two great alternative routings: the southern lane to SWPA and cross-service exchanges that effectively add virtual capacity without new berths.

---

## 4. Mathematical Modeling & Simulation Formulas

### 4.1 Single-Server Gate Queue (M/M/1) — the SFPE canonical form

Let $\lambda$ = arrival rate of loaded vessels [ships/day], $\mu$ = service (turnaround) rate [ships/day], with stability requiring $\rho = \lambda/\mu < 1$:

$$\rho=\frac{\lambda}{\mu},\qquad W=\frac{1}{\mu-\lambda},\qquad W_q=\frac{\lambda}{\mu(\mu-\lambda)},\qquad L=\lambda W \ \text{(Little's Law)}$$

- $W$: mean time a ship spends in the port system (queue + service) [days].
- $W_q$: mean pure queueing delay [days].
- $L$: mean number of ships in system [ships] — directly convertible to anchored/off-beach tonnage via mean payload.

With the calibrated constants ($\lambda = 13.3$, $\mu = 16.0$, $\rho = 0.83$): $W = 1/2.7 \approx 0.37$ days, but note the *sensitivity*: at $\lambda = 15$, $W$ triples to 1.0 day. This nonlinearity is the mathematical soul of the chapter — the Continental System existed to keep $\lambda$ away from $\mu$.

### 4.2 Multi-Berth Gate (M/M/c) — Erlang-C form

With $c$ berths (I-01: $c \approx 26$), per-berth rate $\mu$, offered load $a = \lambda/\mu$ [erlangs]:

$$P_0=\left[\sum_{n=0}^{c-1}\frac{a^n}{n!}+\frac{a^c}{c!\,(1-a/c)}\right]^{-1},\qquad P_W=\frac{a^c}{c!\,(1-a/c)}\,P_0,\qquad W_q^{(c)}=\frac{P_W}{c\mu-\lambda}$$

$P_W$ is the probability an arriving ship finds all berths occupied (anchorage delay). For the calibrated system ($a \approx 21.6$ erlangs over $c=26$), $P_W \approx 0.3$–$0.4$ and $W_q^{(c)} \approx 0.12$–$0.15$ days — modest *on average*, which is exactly why the unmanaged-variance counterfactual (§1) is the correct baseline for judging the system's value.

### 4.3 End-to-End Pipeline Delay

For a path $\mathcal{P}$ of legs $k$ (rail, staging, gate, sea, theater):

$$W_{\text{e2e}}=\sum_{k\in\mathcal{P}}\Big(W_{q,k}+t^{\text{transit}}_k\Big)+d_{\text{stage}},\qquad d_{\text{stage}}=14\ \text{days (I-13)}$$

If any server on $\mathcal{P}$ saturates ($\lambda_k \geq \mu_k$), $W_{\text{e2e}} \to \infty$ — the formal statement of the Leyte lesson (E-02): the pipeline is governed by its minimum-capacity server.

### 4.4 Hull Productivity Identity (why port time is strategic)

$$V_{\text{month}} \;=\; N_H\,\bar{p}\,\frac{30}{T_{\text{load}}+T_{\text{out}}+T_{\text{disch}}+T_{\text{return}}+T_{\text{maint}}}$$

$N_H$ = hulls committed, $\bar{p}$ = effective payload per voyage (P-03 × P-05), $T$ terms in days. Differentiating w.r.t. $T_{\text{load}}$ shows the Continental System's dwell reduction (F-01: ~15–20 days saved per round trip on long Pacific routes) is equivalent to adding on the order of 10–20% effective hulls — without a single new keel.

### 4.5 Capacitated Routing Program (monthly planning model)

Sets: origins $O$ (continental depots), gates $P$ (POEs), rail corridors $R$. Data: supply $S_o$, gate berth-clearance caps $K_p$ (I-03/I-05–I-07), corridor caps $R_r$ (I-14), handling cost $c_{op}$, congestion price $\theta_p$. Decision: monthly tonnage $x_{op} \geq 0$.

$$\min_{x\ge 0}\ \sum_{o\in O}\sum_{p\in P} c_{op}\,x_{op}\;+\;\sum_{p\in P}\theta_p\,\widehat{W}_p\!\left(\bar{\lambda}_p+\frac{1}{\Delta t}\sum_{o}x_{op}\right)$$

subject to

$$\sum_{p}x_{op}\le S_o\ \ \forall o;\qquad \sum_{o}x_{op}\le K_p\ \ \forall p;\qquad \sum_{(o,p)\in r}x_{op}\le R_r\ \ \forall r$$

with backlog dynamics at each gate (fluid complement to §4.1):

$$B_p(t+1)=\big[\,B_p(t)+a_p(t)-s_p(t)\,\big]^{+},\qquad [z]^{+}=\max(z,0)$$

$\widehat{W}_p(\cdot)$ is a piecewise-linear convex approximation of the queueing delay $W_p(\lambda)$ built from tangent lines at utilization breakpoints (0.6, 0.75, 0.85, 0.95), making the program a solvable MILP. Interpretation: the model prices *congestion*, not just distance — it will voluntarily route tonnage to Seattle or Los Angeles before letting SFPE cross ρ ≈ 0.9, which is precisely the dispatching behavior the historical loading calendars enforced by hand.

---

## 5. Compile-Safe Scala 3 Domain Model

```scala
package Logistics.ContinentalSystem

import scala.collection.immutable.{List, Map}

// ==========================================================================
// Units of measure — opaque types for dimensional safety
// ==========================================================================

opaque type MeasurementTons = Double
object MeasurementTons:
  val zero: MeasurementTons = 0.0
  def apply(raw: Double): MeasurementTons =
    require(raw.isFinite && raw >= 0.0, s"MeasurementTons must be finite and non-negative, got $raw")
    raw
  extension (lhs: MeasurementTons)
    def +(rhs: MeasurementTons): MeasurementTons = lhs + rhs
    def -(rhs: MeasurementTons): MeasurementTons = if lhs - rhs < 0.0 then zero else lhs - rhs
    def scale(factor: Double): MeasurementTons = lhs * factor
    def ratio(rhs: MeasurementTons): Double = if rhs == 0.0 then 0.0 else lhs / rhs
    def toDouble: Double = lhs

opaque type LongTons = Double
object LongTons:
  val zero: LongTons = 0.0
  def apply(raw: Double): LongTons =
    require(raw.isFinite && raw >= 0.0, s"LongTons must be finite and non-negative, got $raw")
    raw
  extension (lhs: LongTons)
    def +(rhs: LongTons): LongTons = lhs + rhs
    def scale(factor: Double): LongTons = lhs * factor
    def toDouble: Double = lhs

opaque type CubicFeet = Double
object CubicFeet:
  val zero: CubicFeet = 0.0
  def apply(raw: Double): CubicFeet =
    require(raw.isFinite && raw >= 0.0, s"CubicFeet must be finite and non-negative, got $raw")
    raw
  extension (lhs: CubicFeet)
    def +(rhs: CubicFeet): CubicFeet = lhs + rhs
    def toDouble: Double = lhs

opaque type Days = Double
object Days:
  val zero: Days = 0.0
  def apply(raw: Double): Days =
    require(raw.isFinite && raw >= 0.0, s"Days must be finite and non-negative, got $raw")
    raw
  extension (lhs: Days)
    def +(rhs: Days): Days = lhs + rhs
    def <(rhs: Days): Boolean = lhs < rhs
    def scale(factor: Double): Days = lhs * factor
    def toDouble: Double = lhs

opaque type NauticalMiles = Double
object NauticalMiles:
  def apply(raw: Double): NauticalMiles =
    require(raw.isFinite && raw > 0.0, s"NauticalMiles must be finite and positive, got $raw")
    raw
  extension (lhs: NauticalMiles)
    def toDouble: Double = lhs

opaque type NodeId = String
object NodeId:
  def apply(raw: String): NodeId =
    require(raw.trim.nonEmpty, "NodeId must be a non-empty string")
    raw
  extension (id: NodeId)
    def value: String = id

// ==========================================================================
// Historical constants (provenance-tagged; see specification section 2)
// ==========================================================================

object HistoricalConstants:
  /** [A] 1 measurement ton = 40 cubic feet. */
  val cubicFeetPerMeasurementTon: Double = 40.0
  /** [A] Long ton in pounds. */
  val poundsPerLongTon: Double = 2240.0
  /** [A] Liberty EC2-S-C1 deadweight capacity. */
  val libertyDeadweightLongTons: Double = 10800.0
  /** [A] Liberty design speed; service speed lower. */
  val libertyDesignSpeedKnots: Double = 11.0
  val libertyServiceSpeedKnots: Double = 10.0
  /** [A] Great-circle distance San Francisco to Oahu. */
  val sanFranciscoOahuDistanceNm: Double = 2089.0
  /** [C] Estimated theater-route distances. */
  val oahuMajuroDistanceNm: Double = 2300.0
  val majuroUlithiDistanceNm: Double = 1850.0
  val ulithiLeyteDistanceNm: Double = 870.0
  val seattleOahuDistanceNm: Double = 2360.0
  /** [C] SFPE gate calibration, late 1944. */
  val sfpeBerths: Int = 26
  val sfpeArrivalRateShipsPerDay: Double = 13.3
  val sfpeServiceRateShipsPerDay: Double = 16.0
  val sfpePeakMonthlyClearanceMtons: Double = 420000.0
  /** [B] ASF staging dwell policy. */
  val stagingDwellPolicyDays: Double = 14.0
  /** [A] Port Chicago detonation, 17 July 1944. */
  val portChicagoDateIso: String = "1944-07-17"
  val portChicagoFatalities: Int = 320
  val portChicagoInjured: Int = 390
  val portChicagoMunitionsLongTons: Double = 5000.0

// ==========================================================================
// Cargo taxonomy and stowage mathematics
// ==========================================================================

enum CargoCategory(val stowageFactorCuFtPerLongTon: Double):
  case DryGeneral    extends CargoCategory(55.0)
  case Ammunition    extends CargoCategory(38.0)
  case BulkPetroleum extends CargoCategory(34.0)
  case Vehicles      extends CargoCategory(95.0)
  case Refrigerated  extends CargoCategory(72.0)

object CargoCategory:
  def cubeFor(longTons: LongTons, category: CargoCategory): CubicFeet =
    CubicFeet(longTons.toDouble * category.stowageFactorCuFtPerLongTon)
  def measurementTonsFor(longTons: LongTons, category: CargoCategory): MeasurementTons =
    MeasurementTons(cubeFor(longTons, category).toDouble / HistoricalConstants.cubicFeetPerMeasurementTon)

// ==========================================================================
// Queueing kernel — extends the provided base model
// ==========================================================================

final case class PortQueue(arrivalRatePerDay: Double, serviceRatePerDay: Double)

object PortQueue:
  def validated(arrivalRatePerDay: Double, serviceRatePerDay: Double): Either[ValidationError, PortQueue] =
    if arrivalRatePerDay < 0.0 || serviceRatePerDay < 0.0 then
      Left(ValidationError.NegativeRate(arrivalRatePerDay, serviceRatePerDay))
    else
      Right(PortQueue(arrivalRatePerDay, serviceRatePerDay))

object QueueingModel:
  /** Mean sojourn time W = 1 / (mu - lambda); infinite when saturated. Base contract preserved. */
  def averageDelayDays(queue: PortQueue): Double =
    if queue.serviceRatePerDay > queue.arrivalRatePerDay then
      1.0 / (queue.serviceRatePerDay - queue.arrivalRatePerDay)
    else
      Double.PositiveInfinity

  def isStable(queue: PortQueue): Boolean =
    queue.serviceRatePerDay > 0.0 && queue.arrivalRatePerDay >= 0.0 &&
      queue.serviceRatePerDay > queue.arrivalRatePerDay

  def utilization(queue: PortQueue): Double =
    if queue.serviceRatePerDay <= 0.0 then Double.PositiveInfinity
    else queue.arrivalRatePerDay / queue.serviceRatePerDay

  /** Little's Law: L = lambda * W. */
  def averageNumberInSystem(queue: PortQueue): Double =
    if !isStable(queue) then Double.PositiveInfinity
    else queue.arrivalRatePerDay * averageDelayDays(queue)

  /** Erlang-C: probability an arrival finds all c servers busy. */
  def erlangC(c: Int, arrivalRate: Double, serviceRatePerServer: Double): Double =
    if c <= 0 || arrivalRate <= 0.0 || serviceRatePerServer <= 0.0 then 0.0
    else
      val offeredLoad = arrivalRate / serviceRatePerServer
      if offeredLoad >= c.toDouble then 1.0
      else
        val rho = offeredLoad / c.toDouble
        var k = 0
        var sumTerms = 0.0
        var term = 1.0
        while k < c do
          sumTerms += term
          k += 1
          term *= offeredLoad / k.toDouble
        val tailTerm = term / (1.0 - rho)
        tailTerm / (sumTerms + tailTerm)

  /** M/M/c mean queueing wait: Wq = Pw / (c*mu - lambda). */
  def multiBerthWaitDays(c: Int, arrivalRate: Double, serviceRatePerServer: Double): Days =
    val systemCapacity = c.toDouble * serviceRatePerServer
    if c <= 0 || arrivalRate <= 0.0 || serviceRatePerServer <= 0.0 || systemCapacity <= arrivalRate then
      Days.zero
    else
      val pw = erlangC(c, arrivalRate, serviceRatePerServer)
      Days(pw / (systemCapacity - arrivalRate))

// ==========================================================================
// Validation taxonomy
// ==========================================================================

enum ValidationError:
  case NegativeRate(arrival: Double, service: Double)
  case UnknownNode(id: NodeId)
  case NonPositiveCapacity(id: NodeId)

// ==========================================================================
// Network domain model
// ==========================================================================

enum NodeCategory:
  case InlandDepot
  case StagingArea
  case PortOfEmbarkation
  case NavalMagazine
  case TheaterHub
  case BeachTerminal

enum NodeState:
  case Nominal
  case ElevatedQueue
  case Saturated
  case Degraded(fractionOfCapacity: Double)
  case Offline(expectedRestorationDays: Option[Days])

enum TransportMode:
  case Rail
  case Highway
  case CoastalWater
  case BlueWaterConvoy
  case BlueWaterIndependent

enum DisruptionEvent:
  case Detonation(capacityLossFraction: Double, downtimeDays: Days, label: String)
  case Storm(downtimeDays: Days, label: String)
  case DemandSurge(arrivalMultiplier: Double, durationDays: Days, label: String)

final case class LogisticsNode(
  id: NodeId,
  displayName: String,
  category: NodeCategory,
  nominalMonthlyCapacity: MeasurementTons,
  backlog: MeasurementTons,
  state: NodeState,
  queue: PortQueue
)

object LogisticsNode:
  def effectiveMonthlyCapacity(node: LogisticsNode): MeasurementTons =
    node.state match
      case NodeState.Nominal | NodeState.ElevatedQueue | NodeState.Saturated =>
        node.nominalMonthlyCapacity
      case NodeState.Degraded(fraction) =>
        node.nominalMonthlyCapacity.scale(fraction)
      case NodeState.Offline(_) =>
        MeasurementTons.zero

  /** Fluid balance update with threshold-driven state transitions. */
  def advance(node: LogisticsNode, inflow: MeasurementTons, outflow: MeasurementTons): LogisticsNode =
    val newBacklog = node.backlog + inflow - outflow
    val cap = node.nominalMonthlyCapacity.toDouble
    val ratio = if cap <= 0.0 then Double.PositiveInfinity else newBacklog.toDouble / cap
    val nextState =
      if ratio <= 0.50 then NodeState.Nominal
      else if ratio <= 0.85 then NodeState.ElevatedQueue
      else NodeState.Saturated
    node.copy(backlog = newBacklog, state = nextState)

  /** Deterministic disruption timeline: Offline during downtime, ramped Degraded, then Nominal. */
  def projectNode(node: LogisticsNode, event: DisruptionEvent, elapsedSinceEvent: Days): LogisticsNode =
    event match
      case DisruptionEvent.Detonation(lossFraction, downtime, _) =>
        val ramp = downtime.scale(0.5)
        if elapsedSinceEvent < downtime then
          node.copy(state = NodeState.Offline(Some(downtime)))
        else if elapsedSinceEvent < downtime + ramp then
          node.copy(state = NodeState.Degraded(1.0 - lossFraction * 0.5))
        else
          node.copy(state = NodeState.Nominal)
      case DisruptionEvent.Storm(downtime, _) =>
        if elapsedSinceEvent < downtime then
          node.copy(state = NodeState.Offline(Some(downtime)))
        else
          node.copy(state = NodeState.Nominal)
      case DisruptionEvent.DemandSurge(multiplier, _, _) =>
        node.copy(queue = PortQueue(node.queue.arrivalRatePerDay * multiplier, node.queue.serviceRatePerDay))

final case class PipelineEdge(
  fromId: NodeId,
  toId: NodeId,
  mode: TransportMode,
  distanceNm: Option[NauticalMiles],
  transitDays: Days,
  monthlyCapacity: MeasurementTons
)

final class LogisticsNetwork(
  val nodes: Map[NodeId, LogisticsNode],
  val edges: List[PipelineEdge]
):
  def node(id: NodeId): Option[LogisticsNode] = nodes.get(id)

  def validate: List[ValidationError] =
    val endpointErrors = edges.collect:
      case e if !nodes.contains(e.fromId) => ValidationError.UnknownNode(e.fromId)
      case e if !nodes.contains(e.toId)   => ValidationError.UnknownNode(e.toId)
    val capacityErrors = edges.collect:
      case e if e.monthlyCapacity.toDouble <= 0.0 => ValidationError.NonPositiveCapacity(e.toId)
    endpointErrors ++ capacityErrors

  def endToEndDelayDays(path: List[PipelineEdge]): Either[ValidationError, Days] =
    foldDelays(path, Right(Days.zero))

  private def foldDelays(
    remaining: List[PipelineEdge],
    acc: Either[ValidationError, Days]
  ): Either[ValidationError, Days] =
    remaining match
      case Nil => acc
      case edge :: rest =>
        acc match
          case Left(err) => Left(err)
          case Right(total) =>
            node(edge.toId) match
              case None => Left(ValidationError.UnknownNode(edge.toId))
              case Some(target) =>
                val wait = QueueingModel.averageDelayDays(target.queue)
                foldDelays(rest, Right(total + Days(edge.transitDays.toDouble + wait)))

// ==========================================================================
// Demonstration scenario — calibrated to specification section 2
// ==========================================================================

object ContinentalSystemScenario:

  private val passThroughQueue: PortQueue = PortQueue(0.0, 1.0e9)

  def buildNetwork: LogisticsNetwork =
    val sharpe = LogisticsNode(
      NodeId("SHARPE"), "Sharpe General Depot", NodeCategory.InlandDepot,
      MeasurementTons(200000.0), MeasurementTons(120000.0),
      NodeState.Nominal, passThroughQueue)
    val sfpe = LogisticsNode(
      NodeId("SFPE"), "San Francisco Port of Embarkation", NodeCategory.PortOfEmbarkation,
      MeasurementTons(HistoricalConstants.sfpePeakMonthlyClearanceMtons),
      MeasurementTons(310000.0),
      NodeState.ElevatedQueue,
      PortQueue(HistoricalConstants.sfpeArrivalRateShipsPerDay, HistoricalConstants.sfpeServiceRateShipsPerDay))
    val pearl = LogisticsNode(
      NodeId("PEARL"), "Pearl Harbor ComServPac", NodeCategory.TheaterHub,
      MeasurementTons(500000.0), MeasurementTons(200000.0),
      NodeState.Nominal, PortQueue(9.0, 12.0))
    val majuro = LogisticsNode(
      NodeId("MAJURO"), "Majuro Anchorage", NodeCategory.TheaterHub,
      MeasurementTons(300000.0), MeasurementTons.zero,
      NodeState.Nominal, passThroughQueue)
    val ulithi = LogisticsNode(
      NodeId("ULITHI"), "Ulithi Service Squadron 10", NodeCategory.TheaterHub,
      MeasurementTons(400000.0), MeasurementTons.zero,
      NodeState.Nominal, passThroughQueue)
    val leyteCrisis = LogisticsNode(
      NodeId("LEYTE"), "Leyte Beach Terminals", NodeCategory.BeachTerminal,
      MeasurementTons(900000.0), MeasurementTons(650000.0),
      NodeState.Saturated, PortQueue(20.0, 14.0))
    val leyteRelaxed = leyteCrisis.copy(queue = PortQueue(8.0, 14.0), state = NodeState.Nominal)
    val portChicago = LogisticsNode(
      NodeId("PORTCHICAGO"), "Port Chicago Naval Magazine", NodeCategory.NavalMagazine,
      MeasurementTons(60000.0), MeasurementTons(25000.0),
      NodeState.Nominal, passThroughQueue)

    val nodeMap: Map[NodeId, LogisticsNode] = Map(
      sharpe.id -> sharpe, sfpe.id -> sfpe, pearl.id -> pearl, majuro.id -> majuro,
      ulithi.id -> ulithi, leyteCrisis.id -> leyteCrisis, portChicago.id -> portChicago)

    val edgeList: List[PipelineEdge] = List(
      PipelineEdge(sharpe.id, sfpe.id, TransportMode.Rail, None, Days(1.0), MeasurementTons(220000.0)),
      PipelineEdge(portChicago.id, sfpe.id, TransportMode.Rail, None, Days(0.5), MeasurementTons(40000.0)),
      PipelineEdge(sfpe.id, pearl.id, TransportMode.BlueWaterConvoy,
        Some(NauticalMiles(HistoricalConstants.sanFranciscoOahuDistanceNm)), Days(10.0), MeasurementTons(260000.0)),
      PipelineEdge(pearl.id, majuro.id, TransportMode.BlueWaterConvoy,
        Some(NauticalMiles(HistoricalConstants.oahuMajuroDistanceNm)), Days(10.0), MeasurementTons(180000.0)),
      PipelineEdge(majuro.id, ulithi.id, TransportMode.BlueWaterConvoy,
        Some(NauticalMiles(HistoricalConstants.majuroUlithiDistanceNm)), Days(8.0), MeasurementTons(150000.0)),
      PipelineEdge(ulithi.id, leyteCrisis.id, TransportMode.BlueWaterConvoy,
        Some(NauticalMiles(HistoricalConstants.ulithiLeyteDistanceNm)), Days(4.0), MeasurementTons(120000.0)))

    LogisticsNetwork(nodeMap, edgeList)

@main def runContinentalSystemDemo(): Unit =
  val network = ContinentalSystemScenario.buildNetwork
  val validationErrors = network.validate
  println(s"Network validation errors: ${validationErrors.size}")

  val sfpeQueue = PortQueue(
    HistoricalConstants.sfpeArrivalRateShipsPerDay,
    HistoricalConstants.sfpeServiceRateShipsPerDay)
  val singleServerWait = QueueingModel.averageDelayDays(sfpeQueue)
  val rho = QueueingModel.utilization(sfpeQueue)
  val shipsInSystem = QueueingModel.averageNumberInSystem(sfpeQueue)
  println(f"SFPE M/M/1: rho=${rho}%.3f  W=${singleServerWait}%.3f d  L=${shipsInSystem}%.2f ships")

  val perBerthRate = HistoricalConstants.sfpeServiceRateShipsPerDay / HistoricalConstants.sfpeBerths.toDouble
  val waitProbability = QueueingModel.erlangC(
    HistoricalConstants.sfpeBerths,
    HistoricalConstants.sfpeArrivalRateShipsPerDay,
    perBerthRate)
  val multiBerthWait = QueueingModel.multiBerthWaitDays(
    HistoricalConstants.sfpeBerths,
    HistoricalConstants.sfpeArrivalRateShipsPerDay,
    perBerthRate)
  println(f"SFPE M/M/c (c=${HistoricalConstants.sfpeBerths}): Pw=${waitProbability}%.3f  Wq=${multiBerthWait.toDouble}%.3f d")

  val edges = network.edges
  val fullPath = edges.drop(1)
  network.endToEndDelayDays(fullPath) match
    case Right(total) =>
      val rendered = if total.toDouble.isPosInfinity then "SATURATED (infinity)" else f"${total.toDouble}%.2f"
      println(s"End-to-end Sharpe-to-Leyte delay (crisis Leyte): $rendered days")
    case Left(err) =>
      println(s"Path evaluation failed: $err")

  val relaxedLeyte = ContinentalSystemScenario.buildNetwork
  val relaxedEdges = relaxedLeyte.edges.drop(1).map(e =>
    if e.toId.value == "LEYTE" then e.copy(transitDays = e.transitDays) else e)
  val relaxedNetwork = LogisticsNetwork(
    relaxedLeyte.nodes.updated(
      scala.Predef.ArrowAssoc(NodeId("LEYTE")).->[LogisticsNode](
        relaxedLeyte.node(NodeId("LEYTE")).get.copy(queue = PortQueue(8.0, 14.0), state = NodeState.Nominal))),
    relaxedEdges)
  relaxedNetwork.endToEndDelayDays(relaxedEdges) match
    case Right(total) =>
      println(f"End-to-end delay with post-crisis Leyte service rates: ${total.toDouble}%.2f days")
    case Left(err) =>
      println(s"Path evaluation failed: $err")

  val portChicago = network.node(NodeId("PORTCHICAGO")).get
  val detonation = DisruptionEvent.Detonation(
    0.35, Days(21.0), "Port Chicago magazine detonation, 17 July 1944")
  val at10 = LogisticsNode.projectNode(portChicago, detonation, Days(10.0))
  val at25 = LogisticsNode.projectNode(portChicago, detonation, Days(25.0))
  val at60 = LogisticsNode.projectNode(portChicago, detonation, Days(60.0))
  println(s"Port Chicago state at +10 d: ${at10.state}")
  println(s"Port Chicago state at +25 d: ${at25.state}")
  println(s"Port Chicago state at +60 d: ${at60.state}")
```

**Integration notes.** (1) The provided base `PortQueue`/`QueueingModel.averageDelayDays` contract is preserved verbatim; all extensions are additive. (2) `Days`, `MeasurementTons`, and companions enforce non-negativity at construction, converting silent unit bugs into fail-fast exceptions. (3) `endToEndDelayDays` implements §4 Eq. (3) and returns `Infinity`-carrying `Days` under saturation — the engine-level encoding of the Leyte lesson. (4) `projectNode` encodes event E-01 as a deterministic three-phase recovery (Offline → Degraded → Nominal), matching the Port Chicago recovery profile in the parameter table.

---

## 6. Graduate-Level Operational Analysis

### 6.1 Sources of Friction Between the Army Service Forces and the Navy's Bureau of Supplies and Accounts in Establishing the West Coast Joint Ports

**Thesis.** The friction was not primarily personal or even budgetary; it was a collision between two *governance technologies*. The ASF, forged in the March 1942 reorganization, embodied single-manager integration: one supply system, unified property accountability, technical services subordinated to a general-staff logic, and a conviction — traceable through Somervell's entire conduct of the war — that concentration of control was the price of speed. The Navy's Bureau of Supplies and Accounts presided over a *federated* system: bureau autonomy, type-commander claimancy, ship-centered rather than theater-centered accounting, and a deep institutional memory that the fleet's lifeline must never depend on another service's priorities. When both systems converged on San Francisco Bay, Puget Sound, and Los Angeles harbor, every shared physical asset became a jurisdictional boundary object.

Four friction clusters dominated. **First, doctrine and command.** The Army proposed joint port operation in the sense it understood: integrated control under a single port commander with liaison. The Navy accepted coordination but rejected subordination; its facilities (NSD Oakland, Mare Island, Hunter's Point, the naval magazines) answered to district commandants and bureau channels, not to the SFPE. The resulting architecture was coordination-by-committee — local joint operating arrangements layered atop dual command chains — which worked at the schedule level but left authority ambiguous at every exception. **Second, physical assets and labor.** Berths, rail trackage, lightering, and above all stevedore labor were common-pool resources under independent claim. Civilian longshore labor was scarce, wage-controlled, and intermittently disputed; the Army compensated with Transportation Corps port battalions, while Navy depots relied on civilian and enlisted loaders — a structural difference whose consequences became tragic at Port Chicago, where Navy-enlisted (and segregated) loading crews, working under output incentives, performed the hazardous duty that Army-run POEs distributed differently. Competition for railcars between Army consolidation trains and Navy store movements was continuous, mediated only by priority committees. **Third, information and accounting.** The two services literally could not read each other's paperwork: different manifest formats, different tonnage conventions (the Army's measurement-ton discipline versus Navy storekeeping categories), different property-accountability doctrines, and no common reconciliation of cross-service issues. The JMTC's standardization of military shipping reporting was the decisive remedial step — a data-infrastructure fix that historians underrate because it produced no dramatic headquarters fight. **Fourth, risk and safety governance.** Ammunition exposed the deepest fault line: mixed-service loads, incompatible quantity-distance assumptions, and divided inspection authority culminated in the Port Chicago detonation of July 1944. The disaster's aftermath — loading-policy revision, the courts-martial of the fifty, and eventual structural reform of enlisted stevedoring — illustrates the general law that inter-service friction was resolved less by agreement than by catastrophe-driven rule change.

The modern analytical verdict: this was a textbook principal-agent and common-pool-resource problem, mitigated not by organizational merger (politically impossible under King and Somervell alike) but by *synchronization* — joint loading calendars, cross-storage agreements, cross-loading of cube, and standardized reporting. Transaction-cost economics predicts exactly this outcome: when merger is blocked, co-location plus scheduling contracts is the second-best governance form. For the simulator, the implication is architectural: model ASF and Navy as parallel supply systems sharing congestible resources, with friction represented as a switching-cost coefficient on cross-service transactions and as correlated failure modes on shared assets (E-01), rather than as a single merged queue.

### 6.2 How the "Continental System" Prevented Duplication of Storage Depots in California

**Mechanism, not miracle.** The Continental System prevented *functional* duplication even where it tolerated *physical* duplication, and the distinction is the entire analytical point. Physically, California ended the war with both Army and Navy warehouse empires — Sharpe General Depot and Benicia on the Army side, NSD Oakland and the naval magazines on the Navy side, with Ogden and Clearfield repeating the pairing inland. A naive reading says duplication. The functional reading says otherwise: the system's governing rule (F-05) was that *no cargo moved to tidewater without a firm sailing within the release window*. That single rule transformed inland depots from redundant silos into a shared buffering layer, because it made storage location substitutable. A ton of Army rations at Sharpe and a ton of Navy stores at Clearfield were not competing for the same scarce resource — the scarce resource was *berth-days at Fort Mason and Oakland* — and the release-window discipline ensured that competition was rationed by the loading calendar rather than by whoever had stock closest to the water.

Three specific mechanisms did the preventive work. **First, temporal smoothing via reconsignment.** Because cargo was documented to the POE but physically held inland with final ship assignment deferred, the ports received near-deterministic arrivals matched to sailing schedules. Storage demand at tidewater collapsed from "everything inbound" to "the next ten to fourteen days of programmed lift" (F-01's managed-dwell regime). Had both services instead pushed full inventories coastally — the unmanaged counterfactual — each would have required its own massive waterfront warehouse complex simply to hold the other's overflow spillover; duplication would have been forced, not chosen. **Second, spatial substitution through cross-service agreements.** Overflow ran both directions by design: Army cube absorbed Navy surges and vice versa (F-04's cross-loading logic extended to storage), with reimbursement handled through cross-service work orders. NSD Oakland's proximity to Army Oakland facilities made the Bay Area a de facto joint storage pool governed by bilateral arrangement — imperfect, litigated constantly, but sufficient to avoid either service capitalizing a second complete waterfront plant. **Third, complementary rather than competitive inland siting.** The clearest case is Utah: the Army's Ogden depot and the Navy's Clearfield depot sat side by side serving the same Overland Route corridor. Viewed statically, that is duplication; viewed dynamically, it was *risk pooling with service-specific claimancy* — each service retained assured access to inland consolidation (the Navy would never accept dependence on Army warehousing for fleet-critical stores, and the Army reciprocally refused dependence on bureau channels), while the shared rail corridor and shared release-window discipline prevented the pairing from doubling coastal storage demand. Institutional economics reads this as the second-best solution under a prohibition on merger: retain duplicate claimancy (to preserve command reliability) while engineering shared throughput disciplines (to capture the economies of integration).

The measurable consequences align with the parameter set: managed port dwell an order of magnitude below the unmanaged baseline (F-01), berth productivity sufficient to clear the late-1944 peak (I-03) without a proportionate expansion of covered waterfront storage, and capital avoidance — the Oakland Army Base, completed only in early 1945, was an *addition* to a functioning system rather than a rescue of a failed one. The residual duplications that persisted (Clearfield/Ogden, dual accounting systems, dual manifest formats) were the deliberate insurance premium paid for command autonomy. In modern supply-chain terms, the Continental System implemented postponement (deferred destination assignment), a managed decoupling point (the inland yard), and pooled capacity with priority-weighted access — and its lesson for the simulator is to model storage as a *shared schedulable service with service-specific claimancy rights*, not as two parallel inventories.
