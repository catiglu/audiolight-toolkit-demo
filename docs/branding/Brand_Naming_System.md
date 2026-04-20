# Brand Naming System (Audio/Light Stimulation Toolchain)

**Research Use Only. Not for clinical use.**

## Goals

- Emphasise an audio/visual stimulation toolchain (engineering + reproducibility).
- Avoid medical claims, disease names, and clinical positioning.
- Be readable, pronounceable, and safe for international OSS audiences.
- Enable consistent naming across repository, app, packages, and documentation.

## Naming Constraints (Hard Rules)

- Do not use disease names (e.g., “Alzheimer”, “AD”) or treatment language (e.g., “cure”, “therapy”, “treat”).
- Avoid “medical device” signalling words (e.g., “diagnostic”, “clinical”, “healthcare-grade”).
- Avoid protected marks or likely-confusing similarities (unknown until search; see validation template).

## Architecture

### 1) Product Name (Public)

Pattern: **[Core Brand] + [Descriptor]**

Descriptors (choose one):
- Toolkit
- Toolchain
- Stimulus Kit
- AV Stimulus Toolkit

### 2) Repository Slug (GitHub)

Pattern: `corebrand-descriptor` or `audiolight-stimulus-toolkit`

Guidelines:
- lowercase, hyphen-separated
- avoid abbreviations that collide with common acronyms

### 3) Android App Name

Pattern: **[Core Brand] Demo** or **[Core Brand] Minimal**

Guidelines:
- keep “Demo/Minimal” to discourage consumer interpretation

### 4) Package / Namespace

Android `applicationId` pattern:
- `org.example.corebrand` (replace `org.example` with your org)

Python module pattern:
- `corebrand_stimulus`

## Candidate Names (3–5) with SWOT

### Option A: AudioLight Stimulus Toolkit

- **Positioning:** descriptive, low-claim, tool-focused
- **Repository slug:** `audiolight-stimulus-toolkit`
- **Strengths:** clear purpose; low trademark aggression; easy compliance messaging
- **Weaknesses:** less “brandable”; longer name
- **Opportunities:** good for SEO; easy to extend with submodules (audio, light, logging)
- **Threats:** generic term makes discoverability harder among similarly named tools

### Option B: LumaTone Toolkit

- **Positioning:** brandable but still neutral
- **Repository slug:** `lumatone-toolkit`
- **Strengths:** memorable; short; avoids disease language
- **Weaknesses:** higher trademark collision risk (needs search)
- **Opportunities:** can umbrella multiple demos and scripts cleanly
- **Threats:** possible conflicts with existing music/lighting products

### Option C: FlickerWave Toolchain

- **Positioning:** emphasises luminance modulation + waveform generation
- **Repository slug:** `flickerwave-toolchain`
- **Strengths:** technically evocative; reinforces “engineering toolchain”
- **Weaknesses:** “flicker” may trigger safety concerns without context
- **Opportunities:** clear separation between stimulus generation and presentation layers
- **Threats:** public perception risk if used without disclaimers

### Option D: PulseLuma AV Toolkit

- **Positioning:** modern and compact; AV-focused
- **Repository slug:** `pulseluma-av-toolkit`
- **Strengths:** distinct; implies timing and modulation
- **Weaknesses:** may sound “wellness-like” if not paired with disclaimers
- **Opportunities:** good for modular naming (PulseLuma Audio, PulseLuma Light)
- **Threats:** trademark uncertainty; possible confusion with consumer devices

### Option E: SineStim Kit

- **Positioning:** waveform-first, engineering audience
- **Repository slug:** `sinestim-kit`
- **Strengths:** short; technical; clearly non-clinical when explained
- **Weaknesses:** may be opaque to non-engineers
- **Opportunities:** easy to brand internal modules (SineStim Android, SineStim Python)
- **Threats:** similarity risk with existing “Stim” libraries; needs search

## Recommendation (Default)

If you want the lowest risk for GitHub public release: **Option A: AudioLight Stimulus Toolkit**.

If you want a stronger brand and accept validation overhead: **Option B: LumaTone Toolkit**.

