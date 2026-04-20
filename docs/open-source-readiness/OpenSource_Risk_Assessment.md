# Open-Source Risk Assessment (Medical-Adjacent Research Reproducibility Pack)

**Document language:** English (Oxford spelling)  
**Last updated:** 2026-04-20  
**Scope:** Repository-level open-source readiness assessment (documentation, code, artefacts)  
**Intended audience:** Maintainers, compliance reviewers, ethics reviewers, and OSS governance reviewers  

## Executive Summary

This repository appears to be a research and educational prototype pack for sensory stimulation (audio + visual modulation) and supporting scripts. It is **not clinically validated** and must be positioned as **research use only** with explicit restrictions against clinical use and medical claims.

This report provides:
- A hard-gate checklist (automatic **No-Go** conditions).
- An inventory of artefacts with sensitivity and licensing considerations.
- A scored risk model and an initial go/no-go recommendation.
- A mitigation plan to reach a defensible public release posture.

## Intended Use (Public Positioning)

The project is a research and educational reproducibility pack intended to demonstrate a sensory stimulation prototype and related tooling. It is **not intended** for diagnosis, prevention, monitoring, prediction, prognosis, treatment, or alleviation of disease, and must not be used in clinical decision-making or as a medical device.

## Inventory (Artefacts and Data Boundary)

### Data Boundary Policy
- **No real patient data, no PHI/PII, no clinical records** are permitted in this repository.
- Only synthetic or fully anonymised data examples may be included, with a documented de-identification standard.
- Any artefact that could reasonably be linked to an individual (directly or via linkage attacks) is prohibited.

### Repository Inventory (Initial)

| Path (relative) | Artefact type | Contains PII/PHI | Licensing / redistribution notes | Open-source action |
|---|---:|---:|---|---|
| `android-genus-minimal/` | Android demo code | No (expected) | Source code licensing required | Keep |
| `40Hz_goodnizer.py` and related `.py` | Audio generation scripts | No (expected) | Ensure dependencies licensed; document usage | Keep |
| `*.wav` | Audio assets | No (expected) | Must confirm provenance and rights to redistribute | Prefer regenerate or include clear licence/provenance |
| `third_party_pdfs/` | Research PDFs (local-only) | No (expected) | Likely copyrighted third-party documents | **Excluded from VCS**; replace with citations/links |
| `README.md`, `DISCLAIMER.md`, `SECURITY.md` | Governance & safety | No | Required for medical-adjacent positioning | Keep |
| `CONTRIBUTING.md`, `CODE_OF_CONDUCT.md`, `GOVERNANCE.md` | Community governance | No | Required for enforceable boundaries | Keep |
| `.github/` | GitHub governance templates | No | Issue/PR templates reduce PHI/PII and claim risk | Keep |
| `CLA.md` | Contributor agreement | No | Required for safe inbound contributions | Keep |
| `docs/medical-safety/` | Safety/regulatory templates | No | Reduces misuse and ethics ambiguity | Keep |

### Red-Flag Artefact Types (Not Allowed)
- DICOM files, radiology images, pathology slides.
- HL7 v2 messages, FHIR bundles containing patient identifiers.
- Appointment schedules, clinical notes, free-text symptom diaries tied to a person.
- Device identifiers, advertising IDs, phone numbers, email addresses, names.

## Hard Gates (Automatic No-Go)

If any condition below is true, the repository is **No-Go** for public release until remediated:

1. **Real patient data present** (PHI/PII), or re-identification risk beyond a documented, validated threshold.
2. **Clinical claims present** in README, UI text, docs, marketing copy, or issues (e.g., “treats Alzheimer’s”, “improves cognition”).
3. **Missing medical safety disclaimers** and explicit prohibition of clinical use.
4. **Unresolved critical vulnerabilities** in third-party dependencies with credible exploitation paths in typical user environments.
5. **No security disclosure channel** and no adverse event / safety incident routing guidance.
6. **Third-party copyrighted materials** included without redistribution rights (e.g., proprietary PDFs, paywalled papers).

## Scored Risk Model (0–5 per domain)

**Release requirement:** No hard gates triggered **and** weighted score ≥ 4.0.

| Domain | Weight | Score (0–5) | Rationale (current) |
|---|---:|---:|---|
| Legal & Regulatory alignment (HIPAA/GDPR/China DSL/PIPL; SaMD positioning; Part 11 narrative) | 0.20 | 4.0 | Compliance checklist and positioning statements added; scope remains “research only” |
| Data handling & de-identification | 0.20 | 4.5 | Explicit “no patient data” boundary and de-identification standard added |
| Ethics & human factors | 0.15 | 4.0 | Safety warnings and ethics notes provided; further IRB templates recommended |
| Clinical validation status clarity | 0.10 | 4.5 | Intended use and clinical prohibition documented; UI banner added to demo app |
| Security & supply chain | 0.20 | 4.0 | Security reporting policy and dependency audit guidance provided |
| Community & maintenance capacity | 0.15 | 4.0 | Contributing rules, CoC, and governance policy added |

**Weighted score (current):** 4.15 / 5.00

## Go/No-Go Recommendation

**Decision:** **Go (conditional)** for a public open-source release **provided** the hard gates remain satisfied and release packaging excludes `third_party_pdfs/`.

Primary drivers (remediated):
- Medical disclaimers and explicit non-clinical restrictions added.
- Third-party PDFs moved to a local-only folder excluded from version control; citations route established.
- Security disclosure channel and dependency audit guidance added.

## Mitigation Plan (To Reach Go)

### Immediate (Required Before Public Release)
- Done: `README.md` with “Research Use Only” positioning and explicit non-clinical restrictions.
- Done: `DISCLAIMER.md` including photosensitive epilepsy warning and liability limitations.
- Done: `SECURITY.md` including security vulnerability reporting and adverse event routing.
- Done: Third-party PDFs moved to `third_party_pdfs/` and excluded from VCS; bibliography route added.
- Done: Dependency audit guidance (Android + Python) added.
- Done: Contribution rules that prohibit patient data and clinical claims added.

### Recommended (Strongly Advised)
- Add IRB/ethics outreach templates and an open informed consent template (for future studies).
- Add IMDRF SaMD positioning guide and a 21 CFR Part 11 narrative (likely “not applicable” for a demo).
- Add community governance and release process documentation.

## Required Configuration Before Publishing

- Ensure a monitored security intake process exists (e.g., GitHub private vulnerability reports, or a maintainer-controlled secure channel).
- Ensure `third_party_pdfs/` is not included in release archives.

## Evidence and Traceability

This document is the “source of truth” for go/no-go gating. All other compliance and governance documents must be consistent with:
- Intended use statement
- Hard gates
- Data boundary policy

