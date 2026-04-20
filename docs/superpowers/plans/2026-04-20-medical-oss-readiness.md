# Medical Open-Source Readiness Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Produce a complete English (Oxford spelling) open-source readiness documentation and governance pack for a medical-adjacent research reproducibility repository, including risk assessment with go/no-go decision, naming system options, internationalised README, dual-track licensing (Mulan Permissive v2 + commercial addendum), CLA templates, and medical safety/regulatory documentation.

**Architecture:** Documentation-first delivery. Create a stable set of root-level governance/legal files plus structured doc suites under `docs/`. Use a single “source of truth” risk model and cross-link other artefacts to prevent contradictions. Provide templates where external verification is required (trademark/domain checks, certified translation statements).

**Tech Stack:** Markdown, YAML (CITATION.cff), plain text licences. No runtime code changes required unless a disclaimer banner is added to the Android demo UI.

---

## File Structure (To Be Created)

**Root:**
- Create: `README.md`
- Create: `DISCLAIMER.md`
- Create: `LICENSE` (Mulan Permissive License v2 text)
- Create: `COMMERCIAL_TERMS.md`
- Create: `CONTRIBUTING.md`
- Create: `CODE_OF_CONDUCT.md`
- Create: `SECURITY.md`
- Create: `GOVERNANCE.md`
- Create: `CITATION.cff`

**Docs:**
- Create: `docs/open-source-readiness/OpenSource_Risk_Assessment.md`
- Create: `docs/open-source-readiness/Compliance_Checklists.md`
- Create: `docs/open-source-readiness/Ethics_Review_Notes.md`
- Create: `docs/open-source-readiness/Data_Deidentification_Standard.md`
- Create: `docs/open-source-readiness/ThirdParty_Dependency_Audit.md`
- Create: `docs/open-source-readiness/Community_Health_Model.md`
- Create: `docs/regulatory/IMDRF_SaMD_Classification_Guide.md`
- Create: `docs/regulatory/FDA_21CFR_Part11_Electronic_Records.md`
- Create: `docs/regulatory/ISO_14155_Traceability_Table.md`
- Create: `docs/regulatory/HL7_FHIR_Compatibility_Statement.md`
- Create: `docs/medical-safety/Adverse_Event_and_MDR_Process.md`
- Create: `docs/medical-safety/HIPAA_Minimum_Necessary_Checklist.md`
- Create: `docs/medical-safety/Clinical_Validation_Dataset_Guide.md`
- Create: `docs/medical-safety/IRB_Ethics_Committee_Outreach_Templates.md`
- Create: `docs/medical-safety/Informed_Consent_Open_Template.md`
- Create: `docs/medical-safety/Bias_Audit_Plan_for_Medical_AI.md`
- Create: `docs/brand/Naming_System.md`
- Create: `docs/brand/Trademark_and_Terminology_Search_Report.md`
- Create: `docs/brand/Domain_Availability_Report.md`
- Create: `docs/brand/Name_Options_SWOT.md`
- Create: `docs/translation/Certified_Translation_Statement_Template.md`
- Create: `docs/legal/CLA_Individual.md`
- Create: `docs/legal/CLA_Entity.md`
- Create: `docs/legal/Deidentification_Attestation_Template.md`

---

## Task 1: Repository Inventory and Data Boundary Definition

**Files:**
- Create: `docs/open-source-readiness/OpenSource_Risk_Assessment.md` (initial scaffold section: “Inventory”)

- [ ] **Step 1: Identify potentially sensitive artefacts**
  - Search for: datasets, logs, exports, screenshots, device identifiers, email addresses, names, or clinic references.
  - Record findings in the “Inventory” table (path, type, contains PII/PHI? yes/no/unknown, action).

- [ ] **Step 2: Define “No Patient Data” boundary**
  - Add a hard rule: repository must not contain real patient data; provide synthetic data generation guidance instead.
  - Add a “red-flag list” (e.g., DICOM, HL7 v2 messages, appointment schedules, free-text notes).

- [ ] **Step 3: Add risk hard gates**
  - Include the five hard gates from the design spec.

---

## Task 2: Produce the Go/No-Go Risk Assessment Report (Full)

**Files:**
- Modify: `docs/open-source-readiness/OpenSource_Risk_Assessment.md`
- Create: `docs/open-source-readiness/Compliance_Checklists.md`
- Create: `docs/open-source-readiness/Ethics_Review_Notes.md`
- Create: `docs/open-source-readiness/Data_Deidentification_Standard.md`
- Create: `docs/open-source-readiness/ThirdParty_Dependency_Audit.md`
- Create: `docs/open-source-readiness/Community_Health_Model.md`

- [ ] **Step 1: Write the scoring rubric (0–5) and weights**
  - Include: Legal/Regulatory, Data Handling, Ethics, Clinical Validation Status, Security/Supply Chain, Community/Maintenance.
  - Define pass threshold and what triggers No-Go.

- [ ] **Step 2: Write compliance checklists**
  - HIPAA: minimum necessary, administrative/physical/technical safeguards (as applicable), de-identification guidance.
  - GDPR: lawful basis, data minimisation, DPIA triggers, international transfer notes, data subject rights.
  - China DSL/PIPL: data classification, consent, cross-border considerations, security assessment triggers.
  - Add “Applicability Notes”: because the repository is intended to contain no patient data, items become “Not Applicable by Design” with enforcement controls.

- [ ] **Step 3: Write ethics review notes**
  - Include: misuse scenarios, vulnerable populations, photosensitive epilepsy risks, coercion/consent, benefit-risk framing.
  - Include: IRB/ethics committee engagement plan for any future human studies.

- [ ] **Step 4: Write de-identification standard**
  - Define: direct identifiers removal, quasi-identifiers handling, k-anonymity-style guidance, date shifting rules, free-text redaction rules.
  - Provide “Synthetic Data Only” standard for this repository.

- [ ] **Step 5: Write third-party dependency audit report**
  - Android: `./gradlew :app:dependencies` capture; SBOM suggestion (CycloneDX Gradle plugin) and OSV scanning steps.
  - Python: `pip freeze`; SBOM suggestion (CycloneDX Python) and `pip-audit`/OSV scanning steps.
  - Provide a table template: dependency, version, licence, CVE/OSV findings, action.

- [ ] **Step 6: Write community health prediction model**
  - Define metrics: issue response time, PR review time, bus factor, release cadence, security response SLA, documentation coverage.
  - Provide a simple scoring formula and thresholds, plus early warning triggers.

- [ ] **Step 7: Conclude go/no-go for current state**
  - Provide an initial recommendation based on current repository characteristics (no patient data expected; demo code; presence of disclaimers required).
  - List mitigations as actionable checkboxes.

---

## Task 3: Create the Internationalised Medical-Standard README Pack

**Files:**
- Create: `README.md`
- Create: `DISCLAIMER.md`
- Create: `SECURITY.md`
- Create: `CONTRIBUTING.md`
- Create: `CODE_OF_CONDUCT.md`
- Create: `GOVERNANCE.md`
- Create: `CITATION.cff`

- [ ] **Step 1: README structure**
  - Include badges placeholders: build, licence, security policy, DOI/citation, “Research Use Only”.
  - Include sections: Overview, Intended Use, Non-Intended Use, Safety Warnings, Getting Started, Build/Run (dev vs production vs medical environment notes), Data & Privacy, Exported Logs (CSV), Reproducibility, Roadmap, Citation, Contributing, Governance, Security, Disclaimer.
  - Add standards statements: SNOMED CT usage guidance, ICD-11 referencing style, HL7 FHIR compatibility link, ISO 14155 and IEEE 2857 documentation links.

- [ ] **Step 2: DISCLAIMER content**
  - Explicitly prohibit clinical use; add photosensitive epilepsy warning; liability limitation language.

- [ ] **Step 3: SECURITY and incident routing**
  - Separate “security vulnerabilities” from “medical adverse events” reporting routes.

- [ ] **Step 4: CONTRIBUTING medical-specific rules**
  - Require: no real patient data; no clinical claims; evidence for safety-related changes; maintainers may require risk review for changes touching stimuli.

- [ ] **Step 5: CITATION**
  - Provide BibTeX snippet in README plus `CITATION.cff`.

---

## Task 4: Dual-Track Licensing + CLA Pack

**Files:**
- Create: `LICENSE` (Mulan Permissive License v2 text)
- Create: `COMMERCIAL_TERMS.md`
- Create: `docs/legal/CLA_Individual.md`
- Create: `docs/legal/CLA_Entity.md`
- Create: `docs/legal/Deidentification_Attestation_Template.md`

- [ ] **Step 1: Add Mulan Permissive License v2**
  - Include full text.

- [ ] **Step 2: Write commercial addendum**
  - Clauses: medical use liability limits, defensive patent clause, data use tiered authorisation, derivative works notification, mandatory academic citation, model ethics constraints (if ML added).

- [ ] **Step 3: Add CLA templates**
  - Include warranties: contributor has rights; no patient data included; de-identification attestation when contributing data artefacts; compliance acknowledgement.

---

## Task 5: Medical Safety and Regulatory Documentation Suite

**Files:**
- Create: `docs/medical-safety/*` (as listed above)
- Create: `docs/regulatory/*` (as listed above)

- [ ] **Step 1: MDR-style adverse event process**
  - Provide definitions, triage, timelines, and reporting templates (without claiming FDA applicability unless used as a device).

- [ ] **Step 2: HIPAA minimum necessary checklist**
  - Provide operational checklist and design-by-default “no patient data” posture.

- [ ] **Step 3: Clinical validation dataset guide**
  - Provide guidance for future work: dataset governance, consent, provenance, versioning, leakage controls.

- [ ] **Step 4: IRB/ethics templates + informed consent**
  - Provide outreach email template, protocol summary template, and open consent template.

- [ ] **Step 5: IMDRF SaMD classification guide**
  - Provide classification decision tree and examples; explicitly state repository’s intended positioning.

- [ ] **Step 6: 21 CFR Part 11 narrative**
  - Document why the demo likely does not meet Part 11; list controls required if used for electronic records.

- [ ] **Step 7: HL7 FHIR compatibility statement**
  - Provide “not implemented” statement with rationale; define how compatibility would be claimed if later added.

- [ ] **Step 8: ISO 14155 traceability table**
  - Provide a mapping table template: study element → document → status.

- [ ] **Step 9: IEEE 2857 transparency report**
  - Provide a template and a “not applicable” guidance for non-ML demo.

---

## Task 6: Brand Naming System + 3–5 Options with SWOT

**Files:**
- Create: `docs/brand/Naming_System.md`
- Create: `docs/brand/Trademark_and_Terminology_Search_Report.md`
- Create: `docs/brand/Domain_Availability_Report.md`
- Create: `docs/brand/Name_Options_SWOT.md`

- [ ] **Step 1: Define naming rules**
  - Main project name pattern, module naming, abbreviations, versioning, and forbidden words list.

- [ ] **Step 2: Provide search workflow templates**
  - Trademark sources: WIPO, USPTO, EUIPO, CNIPA (document query strings, results, and conflicts).
  - Medical terminology: SNOMED CT (non-redistribution), ICD-11 references (neutrality).

- [ ] **Step 3: Propose 3–5 candidate names**
  - For each: pronunciation note, abbreviation, likely domain patterns, and SWOT.

---

## Task 7: Translation Certification Template and Language Standard

**Files:**
- Create: `docs/translation/Certified_Translation_Statement_Template.md`

- [ ] **Step 1: Provide a template for certified translation statement**
  - Include: agency name placeholders, translator credentials, scope of translation, date, signature block.
  - Include: statement that English version uses Oxford spelling and preserves technical term integrity.

---

## Verification Checklist (Manual)

- [ ] Confirm no real patient data exists anywhere in the repository.
- [ ] Confirm README/Disclaimer contain explicit “research use only” and non-clinical restrictions.
- [ ] Confirm licensing files are present and consistent.
- [ ] Confirm contribution docs prohibit inclusion of patient data and clinical claims.
- [ ] Confirm dependency audit instructions are executable on Windows and macOS/Linux.

---

## Execution Handoff

Plan complete and saved to `docs/superpowers/plans/2026-04-20-medical-oss-readiness.md`.

Two execution options:
1. **Subagent-Driven (recommended)** — I dispatch a fresh subagent per task, review between tasks, fast iteration
2. **Inline Execution** — Execute tasks in this session using executing-plans, batch execution with checkpoints

Which approach?
