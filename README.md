# Green Book Logistics Simulator: Multi-Model Evaluation & Specification Pipeline

An advanced operational research, historical analysis, and software engineering project translating the canonical narrative of the U.S. Army's World War II "Green Book" series—*Global Logistics and Strategy: 1943–1945*—into formal, high-fidelity mathematical models and compile-safe simulation specifications.

---

## 1. Overview & Process Workflow

This repository hosts a fully automated, end-to-end pipeline that ingests historical military outlines, generates highly rigorous chapter-specific prompts, evaluates them across leading Large Language Models (LLMs), and archives the resulting operational manuals and executable simulator modules.

```
       [ Historical Outlines ]
                  │
                  ▼
       [ PromptGenerator.scala ] ──(Generates 32 Prompts)──► [ prompts/ ]
                  │                                               │
                  │                                         (multiModel.sh)
                  │                                               │
                  ▼                                               ▼
       [ results/v2/ (Reports) ] ◄──(OpenRouter Evaluation)───────┘
  (Claude 4.8, GPT-5.6, Kimi, DeepSeek)
```

### The Step-by-Step Pipeline

1. **Source Outlining & Historical Scaffolding**: 
   Historical chapters and sections from the U.S. Army Green Books are indexed in `GlobalLogisticsandStrategy-1943–1945.md` (the general table of contents of the 32 chapters of the main volume) and `greenbookXVtoXIX.md` (theaters of foreign aid, reciprocal aid, and specialized campaigns).

2. **The Prompt Generator Engine (`PromptGenerator.scala`)**: 
   A strongly typed Scala 3 program containing structured metadata for each of the 32 chapters. Each chapter is modeled as a case class defining its era context, specific analytical focus, simulation target (e.g., convoy turnaround, shared-resource queueing, network flow), mathematical equations, starting Scala interfaces, and graduate-level discussion questions.

3. **Materializing Chapter Blueprints (`prompts/`)**: 
   Running the Scala script generates 32 individual markdown prompt specifications under the `prompts/` directory. Each file functions as a detailed, comprehensive blueprint that forces any LLM evaluator to write a highly technical, graduate-level reference manual entry.

4. **Multi-Model Evaluation Pipeline (`multiModel.sh` / `singleModel.sh`)**: 
   Bash scripts orchestrate batch, non-streaming, and diagnostics-guarded API requests through the OpenRouter network. The pipeline sends each materialized prompt to multiple state-of-the-art models:
   * **Anthropic Claude 4.8 Opus** (`anthropic/claude-4.8-opus-20260528`)
   * **OpenAI GPT 5.6 Sol** (`openai/gpt-5.6-sol`)
   * **Moonshot Kimi K2 Thinking** (`moonshotai/kimi-k2-thinking`)
   * **DeepSeek V4 Flash** (`deepseek/deepseek-v4-flash-0731`)

5. **Operational Research Manuals & Code Repository (`results/`)**: 
   The outputs are systematically parsed and stored in `results/Logistics-and-Strategy-v2/` as self-contained markdown manuals. Each generated manual delivers:
   * A minimum **1,000-word deep-dive strategic perspective** on coalition and inter-service tensions.
   * A comprehensive **reference table of empirical constants, coefficients, and metrics** for the simulator's SQL database.
   * A production-grade **Mermaid.js network flowchart** modeling the theater supply lanes.
   * Formal **LaTeX mathematical formulations** of the bottleneck or optimization equations.
   * A **fully implemented, compile-safe, indentation-based Scala 3.8.3 domain model** with opaque types, enums, and ADTs.
   * Rigorous, graduate-level **operational analyses** of theater-specific historical questions.

---

## 2. Directory Structure

```
.
├── GlobalLogisticsandStrategy-1943–1945.md   # Main volume Table of Contents
├── greenbookXVtoXIX.md                       # Foreign aid and specialized theaters TOC
├── PromptGenerator.scala                      # Scala 3 prompt compiler and code generator
├── singleModel.sh                            # Script to evaluate a single chapter/model
├── multiModel.sh                             # Script to run multi-model evaluation matrices
├── prompts/                                  # 32 materialized chapter-specific prompts
│   ├── 01-v2-Logistics-and-Strategy-Spring-1943.md
│   ├── 02-v2-Husky-and-Bolero.md
│   └── ... [32 files]
└── results/
    └── Logistics-and-Strategy-v2/            # Generated research reports & simulator code
        ├── 02-v2-Husky-and-Bolero.md-anthropic-claude-4.8-opus-20260528-v1.md
        ├── 02-v2-Husky-and-Bolero.md-deepseek-deepseek-v4-flash-0731-v1.md
        ├── 02-v2-Husky-and-Bolero.md-moonshotai-kimi-k2-thinking-v1.md
        ├── 02-v2-Husky-and-Bolero.md-openai-gpt-5.6-sol-v1.md
        └── ... [Comprehensive multi-model evaluation reports]
```

---

## 3. The Prompt Specification Anatomy

To ensure that the evaluated models deliver high-fidelity outputs suitable for a production simulator rather than generic textbook summaries, the generated prompts in `prompts/` enforce a strict six-part structural contract:

1. **Strategic Context & Modern Historical Perspective (Min. 1,000 words)**: Deep-dive analysis of coalition tensions (e.g., USASOS vs. Navy, Anglo-American shipping pools), historical era context, and modern analytical insights (such as the impact of combat loading cargo density penalties).
2. **High-Fidelity Simulation Parameters & Real-World Metrics**: A structured markdown table detailing exact empirical values (e.g., Liberty ship deadweight capacities, average turnaround times, convoy cycle days, fuel consumption coefficients, port clearance rates) with clear instructions on how they must be modeled.
3. **Logistical Network Topology (Mermaid.js Flowchart)**: A production flowchart mapping out the theater’s POEs, sea lanes, shipping pools, transfer nodes, advance depots, and combat units with capacities, throughput caps, and weather-dependent congestion loops.
4. **Mathematical Modeling & Simulation Formulas**: A rigorous mathematical formulation using LaTeX (`$$` for block and `$` for inline) specifying decision variables, objective functions (e.g., minimizing weighted strategic supply deficit), constraints, and queue-backpropagation relations.
5. **Compile-Safe Scala 3.8.3 Domain Model**: A complete, strongly-typed, and fully implemented (no `???` or commented placeholders) Scala 3 module utilizing indentation-based syntax, opaque types for unit safety (e.g., `LongTons`, `CubicFeet`, `Days`), enums for state machines, and algebraic data types.
6. **Graduate-Level Operational Analysis**: Detailed answers to intellectually challenging discussion questions, integrating both historical outcomes and quantitative operational principles.

---

## 4. Multi-Model Comparison & Insights

Evaluating the generated prompts across four leading LLM architectures revealed distinct behaviors and strengths:

| Model | Avg. File Size | Code Quality | Analytical Depth | Cost/Speed Profile |
| :--- | :---: | :--- | :--- | :--- |
| **Anthropic Claude 4.8 Opus** | 25–35 KB | **Excellent**: Highly idiomatic, elegant, and compile-safe Scala 3 code. Uses opaque types perfectly. | **Very High**: Captures complex coalition dynamics and historical nuances with academic rigor. | Moderate speed; standard premium pricing. |
| **OpenAI GPT 5.6 Sol** | 50–65 KB | **Robust**: Extremely verbose, fully implemented code blocks with extensive boundary validations. | **Exceptional**: Outstanding long-form manuals, thorough explanations of parameters, and comprehensive mathematical structures. | Slower turnaround; high-value premium pricing. |
| **Moonshot Kimi K2 Thinking** | 30–50 KB | **Good**: Well-structured code blocks, utilizing clean, modern Scala patterns. | **High**: Excellent at deep systemic reasoning, displaying great strength on complex mathematical formulation. | Highly analytical; moderate throughput. |
| **DeepSeek V4 Flash** | 22–32 KB | **Clean**: Highly efficient, perfectly formatted, and fully compliant with the prompt's layout rules. | **High**: Good, concise historical summaries. Ideal for rapid structural verification. | Ultra-fast; highly cost-effective. |

---

## 5. Getting Started & Reproduction

### Prerequisites
* **Scala CLI** (or modern Scala 3 compiler/sbt) installed locally.
* **jq** and **curl** installed for JSON manipulation and API calling.
* An active **OpenRouter API Key** stored in a `.env` file at the root:
  ```env
  OPENROUTER_API_KEY="your-openrouter-key-here"
  ```

### Step 1: Materializing the Prompts
To regenerate the 32 highly detailed chapter prompts from the metadata engine:
```bash
# Using scala-cli to run PromptGenerator.scala directly
scala-cli run PromptGenerator.scala
```
This compile-safe script will verify your directories, compile the domain models, and generate all 32 files in the `prompts/` folder.

### Step 2: Running a Single Model Evaluation
To test a specific prompt against a model:
1. Open `singleModel.sh`.
2. Configure the `MODEL`, `PROMPT_FILE`, `OUT_DIR`, and `OUT_PREFIX` variables.
3. Run the script:
```bash
chmod +x singleModel.sh
./singleModel.sh
```

### Step 3: Running the Multi-Model Evaluation Matrix
To run the full evaluation matrix as demonstrated in `results/Logistics-and-Strategy-v2/` (which processes the prompt and queries all four active OpenRouter slugs sequentially):
```bash
chmod +x multiModel.sh
./multiModel.sh
```

---

## 6. Sample Architecture & Coding Patterns

A key highlight of the generated specifications is the use of **compile-safe Scala 3 patterns** to prevent physical unit collisions. The following pattern is enforced throughout the generated domain models to distinguish long tons, cubic volume, and temporal parameters at compile-time:

```scala
package Logistics.Example

opaque type LongTons = Double
object LongTons:
  def apply(v: Double): LongTons = math.max(0.0, v)
  extension (lt: LongTons)
    def value: Double = lt
    def +(other: LongTons): LongTons = lt + other.value
    def -(other: LongTons): LongTons = lt - other.value

opaque type CubicFeet = Double
object CubicFeet:
  def apply(v: Double): CubicFeet = math.max(0.0, v)
  extension (cf: CubicFeet)
    def value: Double = cf
    def +(other: CubicFeet): CubicFeet = cf + other.value

case class VesselConstraints(weightCapacityTons: LongTons, volumeCapacityCuFt: CubicFeet)

object BalancedLoadingOptimizer:
  // The compiler will reject any attempt to add LongTons directly to CubicFeet,
  // preventing a wide range of common simulation bugs.
  def checkConstraintBinding(v: VesselConstraints, loadedWeight: LongTons, loadedVolume: CubicFeet): Boolean =
    loadedWeight.value <= v.weightCapacityTons.value && loadedVolume.value <= v.volumeCapacityCuFt.value
```

---

## 7. Future Directions

The output files gathered in `results/Logistics-and-Strategy-v2/` provide a ready-to-compile, fully documented library of operational models. The next phase of this project is to:
1. Compile and synthesize the independent Scala 3 domain modules into a unified, modular simulation library.
2. Ingest the tabular simulation metrics directly into a relational database (e.g., PostgreSQL or SQLite) to serve as the baseline historical scenario data.
3. Construct the simulation execution loop to run multi-period, stochastic campaign evaluations of World War II operations under shipping, port, and transportation network-flow bottlenecks.

### that's the plan man
