# Compliance Checklists (Medical-Adjacent Open Source)

**Research Use Only. Not for clinical use.**

## Release Hard Gates (Must Pass)

- [ ] README includes intended use and explicit prohibition of clinical use and claims.
- [ ] DISCLAIMER includes photosensitive seizure warning and liability limitation.
- [ ] SECURITY includes vulnerability reporting and safety incident routing.
- [ ] No patient data (PHI/PII) anywhere in repository, issues, PRs, or releases.
- [ ] No third-party copyrighted PDFs included; use citations/links only.
- [ ] Dependency audit process documented; critical vulnerabilities handled.

## Data Protection (HIPAA / GDPR / China DSL/PIPL)

This repository must remain “no patient data”. Therefore:
- [ ] No collection of identifiers by default (names, emails, device IDs).
- [ ] Exported logs are local-only by default, and documented as potentially sensitive.
- [ ] Issues/PR templates (if added later) warn against posting PHI/PII.

## SaMD / Medical Device Positioning (IMDRF)

For public positioning:
- [ ] Documentation states the project is not intended for diagnosis, treatment, or clinical use.
- [ ] No UI text implies medical efficacy.
- [ ] If future features move toward SaMD, create a separate regulatory track and governance gate.

## 21 CFR Part 11 (Electronic Records)

Current posture:
- [ ] Document “not applicable” for a prototype that does not maintain regulated electronic records.
- [ ] If clinical use is ever pursued, introduce audit trails, access controls, validation protocols, and record retention policies.

## Standards and Terminology (Context-Only Use)

- [ ] SNOMED CT: reference identifiers only; do not redistribute SNOMED CT content.
- [ ] ICD-11: reference codes for taxonomy context only; do not claim clinical diagnosis.
- [ ] HL7 / FHIR: do not include real patient bundles; do not claim interoperability unless implemented and tested.

