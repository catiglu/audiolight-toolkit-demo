---
title: "Medical Open-Source Readiness (Research Reproducibility Pack) — Design"
date: "2026-04-20"
language: "en-GB"
scope: "Repository-level documentation and governance"
---

# Medical Open-Source Readiness (Research Reproducibility Pack) — Design

## Goal
Prepare a medical-adjacent research reproducibility repository for public open-source release by producing a complete, internationally oriented documentation, compliance, ethics, and licensing pack (English, Oxford spelling), and by defining a defensible go/no-go decision with mitigations.

## Non-Goals
- No clinical claims, efficacy claims, or treatment recommendations.
- No distribution of real patient data or protected health information (PHI).
- No representation that the software is a medical device or is suitable for clinical use.
- No guarantee of regulatory clearance; only a transparent statement of regulatory positioning and limitations.

## Project Context (Current State)
- Code present: Android 11+ Kotlin demo (`android-genus-minimal`) and local Python scripts for 40 Hz audio generation.
- Artefacts present: WAV assets for stimulation audio, research PDFs.
- Missing: OSS governance docs, licensing, disclaimers, security policy, compliance/ethics frameworks, contribution rules, and internationally aligned documentation set.

## Open-Source Release Positioning
### Intended Use Statement (Public)
The project is a research and educational reproducibility pack intended to demonstrate a sensory stimulation prototype and related tooling. It is not intended for diagnosis, prevention, monitoring, prediction, prognosis, treatment, or alleviation of disease, and must not be used in clinical decision-making or as a medical device.

### Audience
- Researchers, engineers, and reviewers interested in reproducible prototyping and documentation patterns.
- Not patients, not clinicians using it for patient care.

## Risk Assessment Framework (Decision Backbone)
### Hard Gates (Automatic No-Go)
1. Any inclusion of real patient data, re-identification risk, or PHI/PII beyond permitted anonymised synthetic examples.
2. Any marketing, README, UI text, or documentation that can be reasonably read as a clinical claim (diagnose/treat/mitigate AD, etc.).
3. Absence of medical safety disclaimers and clinical-use prohibitions.
4. Unresolved critical vulnerabilities in third-party dependencies with known exploitation paths.
5. Lack of incident reporting process and security disclosure channel.

### Scored Domains (Go/No-Go with Thresholds)
Each domain is scored 0–5, weighted; release requires (a) no hard gates triggered, and (b) weighted score ≥ 4.0.
- Legal & Regulatory Alignment (HIPAA/GDPR/China DSL/PIPL alignment statements, SaMD positioning, Part 11 narrative)
- Data Handling & De-identification (data minimisation, synthetic dataset plan, de-identification standard)
- Ethics & Human Factors (risk of misuse, photosensitive epilepsy warning, consent template, IRB comms template)
- Clinical Validation Status (clear status: prototype, no clinical validation; if any validation exists, its scope/limitations)
- Security & Supply Chain (SBOM, dependency audit, vuln disclosure, signing guidance)
- Community & Maintenance Capacity (governance model, contribution rules, issue triage, code of conduct)

## Documentation Deliverables (Artefact Map)
### Root Documents
- README (medical OSS standard: badges placeholders, scope, safety, installation, limitations, citation)
- DISCLAIMER (medical use restriction, risk warnings, liability limitations)
- LICENSE (Mulan Permissive License v2)
- COMMERCIAL_TERMS (commercial addendum + special clauses)
- CONTRIBUTING (medical code contribution rules)
- CODE_OF_CONDUCT (medical OSS-specific addenda)
- SECURITY (security reporting + medical incident routing)
- GOVERNANCE (maintainer responsibilities, release policy)
- CITATION.cff (academic citation)

### Docs Suites
- `docs/open-source-readiness/` (risk assessment, checklists, de-identification, dependency audit, community health model)
- `docs/regulatory/` (IMDRF SaMD guide, ISO 14155 traceability table, HL7 FHIR statement, 21 CFR Part 11 narrative)
- `docs/medical-safety/` (MDR process, HIPAA minimum necessary checklist, dataset guide, IRB templates, consent template, bias audit plan)
- `docs/brand/` (naming system, trademark/terminology search report template, domain availability report template, 3–5 name options + SWOT)
- `docs/translation/` (certified translation statement template)

## Naming System Constraints (Brand Design Inputs)
- Must avoid clinical promises (no “cure”, “therapy”, “treatment”, “Alzheimer’s fix”, etc.).
- Must avoid culturally sensitive or potentially misleading terms.
- Must be pronounceable internationally and have a safe abbreviation.
- Must be screened against: WIPO Global Brand Database, USPTO TESS, EUIPO eSearch, CNIPA, and medical terminology references (SNOMED CT browsing/derivative lists where permitted; ICD-11 terms for neutrality).

## Compliance & Standards Alignment (Documentation-Level)
Deliverables will include structured statements and traceability tables:
- SNOMED CT term usage guidance (no redistribution of proprietary SNOMED content; refer by concept IDs where legally permitted)
- ICD-11 referencing style for any disease mentions (avoid claims; only contextual references)
- HL7 FHIR compatibility statement (scope-limited; “non-implementation” allowed if not applicable)
- ISO 14155 traceability table (document mapping, not claiming study compliance)
- IEEE 2857 transparency report template (model-related; “not applicable” sections if no model)
- FDA 21 CFR Part 11 narrative (electronic records: audit trails, retention, integrity; likely “not applicable” to demo, with rationale)

## Security and Privacy Posture
- No collection of personal data by default.
- If logging exists (e.g., CSV), it is local-only and user-controlled export; documentation includes minimisation guidance.
- SBOM and dependency audit procedures documented for Android (Gradle) and Python (pip).

## Acceptance Criteria (Definition of Done)
1. All listed documents exist, are internally consistent, and written in English (Oxford spelling).
2. README and UI-facing text contain explicit non-clinical positioning and disclaimers.
3. Risk assessment yields a clear go/no-go decision rubric and an initial decision for the current repository state.
4. Dependency audit process is documented (SBOM steps and vulnerability scanning instructions).
5. Templates exist for MDR-style incident reporting, IRB outreach, consent, and de-identification.
6. Licensing pack exists: Mulan Permissive v2 + commercial addendum + CLA templates.

