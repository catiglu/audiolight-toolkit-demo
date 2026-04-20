# Data De-identification Standard (Repository Policy)

**Research Use Only. Not for clinical use.**

## Scope

This repository must not contain real patient data. This standard exists to:
- prevent accidental inclusion of PHI/PII in commits, releases, and issue trackers
- define what “synthetic” and “fully anonymised” mean for examples and tests
- provide a minimum bar for de-identification should the project ever include data-like artefacts

## Hard Rule

- **No real patient data, no PHI/PII, no clinical records** are permitted in the repository, issues, pull requests, or releases.

## Allowed Examples

- Synthetic data generated without using real individuals’ records.
- Fully anonymised, aggregated, or simulated measurements where re-identification risk is negligible.
- Toy examples (e.g., random numbers, dummy IDs) that cannot map to a person.

## Not Allowed (Red Flags)

- DICOM, radiology images, pathology slides.
- HL7 v2 messages, FHIR bundles containing identifiers.
- Free-text clinical notes, appointment schedules, symptom diaries tied to a person.
- Device advertising IDs, phone numbers, email addresses, names, addresses, dates of birth.

## Minimum De-identification Expectations (If Data-Like Artefacts Ever Appear)

If a dataset is ever proposed (even de-identified), it must include:
- provenance statement (how created, inputs, licences)
- an explicit de-identification method (removal, generalisation, aggregation)
- a re-identification risk discussion (linkage attack considerations)
- an approval statement (ethics/IRB or organisational governance, if applicable)

## Enforcement

Maintainers will reject contributions containing prohibited artefacts. Reports containing PHI/PII will be deleted or redacted.

