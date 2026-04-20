# Regulatory and Safety Pack (Medical-Adjacent Research Prototype)

**Research Use Only. Not for clinical use.**

This document provides a compact set of narratives and templates to reduce medical-adjacent open-source risk.

## 1. SaMD / Medical Device Positioning (IMDRF)

### Current Position

This repository is an educational and research reproducibility pack. It is not intended for diagnosis, prevention, monitoring, prediction, prognosis, treatment, or alleviation of disease, and must not be used in clinical decision-making.

### Boundary Conditions

If the project evolves toward clinical workflows, patient-facing use, or medical decision support, it may become software that requires a separate regulatory track. In that case, stop public releases and implement a dedicated governance programme (quality management, risk management, clinical evaluation, post-market surveillance).

## 2. 21 CFR Part 11 Narrative (Likely Not Applicable)

### Current Scope

The repository does not claim to create or maintain regulated electronic records. It is therefore expected to be “not applicable” for 21 CFR Part 11 in its current state.

### If Scope Expands

If the software is used to produce or manage records that require regulatory compliance, introduce:
- validated audit trails
- access controls and identity management
- record retention policies
- documented validation protocols and change control

## 3. Minimal Necessary and Privacy (HIPAA/GDPR/China DSL/PIPL)

Repository policy is “no patient data”. If any logs are generated locally:
- treat them as potentially sensitive
- avoid uploading them to public trackers
- minimise retention and sharing

See `docs/open-source-readiness/Data_Deidentification_Standard.md`.

## 4. Medical Device Reporting (MDR) - Incident Handling Template

If a safety incident is reported (e.g., seizure, injury, significant distress):
1. Acknowledge receipt (do not request personal identifiers).
2. Triage severity and immediate containment (recommend stopping use).
3. Record a minimal incident summary (date, environment, app version/commit, stimulus parameters).
4. Assess whether the report indicates a hazard in default behaviour.
5. Publish mitigations (documentation update, safer defaults, warnings) and release notes.
6. If a regulated pathway is later pursued, align incident handling with applicable jurisdictional reporting duties.

## 5. IRB / Ethics Outreach Email (Template)

Subject: Research prototype tool (audio/visual stimulation) – ethics review discussion request

Body (template):
- Project name and link
- Intended use (research only; not clinical; not validated)
- Participant safety considerations (photosensitive epilepsy risk; stop protocol; exclusion criteria)
- Data handling (no PHI/PII; local-only logs; retention policy)
- Requested review scope and timeline

## 6. Informed Consent (Template - High Level)

This is a non-legal template to support ethics discussions. Obtain institutional review where required.

Include:
- purpose (research prototype; no clinical benefit claims)
- procedures (audio/visual stimulation; duration; environment)
- risks (photosensitive seizures; discomfort; headache; nausea; anxiety)
- voluntary participation and withdrawal
- data handling (no identifiers; local storage; retention; sharing policy)
- contact for questions and adverse events

## 7. Dataset and Artefact Distribution Guide (Repository Policy)

### Hard Rule

- Do not add any real patient data (PHI/PII) or clinical records to the repository, issues, pull requests, releases, or discussions.

### Allowed

- Synthetic data generated without using real individuals’ records.
- Simulated or aggregated outputs that cannot be linked to individuals.

### Not Allowed (Examples)

- DICOM, radiology images, pathology slides.
- HL7 v2 messages or FHIR bundles containing identifiers.
- Free-text clinical notes or appointment schedules tied to a person.
- Any file containing names, emails, phone numbers, addresses, dates of birth, device advertising IDs.

### Third-Party Copyrighted Materials

Do not add paywalled or proprietary PDFs. Use bibliographic citations and links instead.

## 8. Interoperability and FHIR Statement (Scope-Limited)

This repository does not claim clinical interoperability. If you export or structure data:
- treat it as a research artefact, not a clinical record
- do not include patient identifiers
- avoid implying conformance to any HL7 FHIR Implementation Guide unless formally implemented and tested

## 9. ISO 14155 Traceability Table (Template)

If the software is used in a clinical investigation context (outside the scope of this repository), maintain a traceability table such as:

| Requirement / Control | Source (protocol/policy) | Implementation location | Verification evidence | Notes |
|---|---|---|---|---|
| Safety warning present | Protocol / participant info sheet | README / DISCLAIMER / UI | Screenshot + release tag | |
| Stop/withdrawal guidance | Consent / protocol | DISCLAIMER / ethics docs | Doc link | |
| Data minimisation (no identifiers) | Data policy | Code + docs | Code review + tests | |
| Incident intake process | Safety policy | SECURITY + issue templates | Issue template link | |

## 10. IEEE 2857 Transparency Report (Template - If ML Is Added)

If machine learning is introduced in the future, publish a short transparency report covering:
- model purpose and intended use (research only; not clinical)
- training data provenance and licences
- known limitations and failure modes
- bias and fairness evaluation summary
- privacy considerations
- update and rollback policy
