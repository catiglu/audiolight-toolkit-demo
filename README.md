# AudioLight Toolkit Demo (Research Reproducibility Pack)

**Research Use Only. Not for clinical use.**

This repository is a **medical-adjacent research and educational reproducibility pack** containing:
- A minimal Android 11+ demo app that plays a WAV file and renders full-screen sinusoidal luminance modulation.
- Supporting scripts for generating audio stimuli (e.g., 40 Hz waveforms).
- Documentation templates for open-source governance, ethics, compliance, and safety incident routing.

## Intended Use

This project is intended to support **research prototyping** and **engineering reproducibility**. It is **not intended** for diagnosis, prevention, monitoring, prediction, prognosis, treatment, or alleviation of disease.

## Non-Intended Use (Prohibited)

- Clinical use in patient care.
- Medical decision-making or clinical workflow integration.
- Claims of therapeutic efficacy or clinical benefit.
- Use by individuals at risk of photosensitive seizures without medical supervision.

## Safety Warnings

Full safety and liability information is provided in [DISCLAIMER.md](DISCLAIMER.md). In summary:
- Visual flicker may trigger photosensitive seizures in susceptible individuals.
- Use of audio/visual stimulation can cause discomfort, headache, nausea, or anxiety.
- Stop immediately if adverse symptoms occur.

## Quick Start (Android Demo)

### Requirements
- Android Studio (recent stable)
- Android 11+ device or emulator
- Android SDK configured (via Android Studio or `ANDROID_SDK_ROOT` / `ANDROID_HOME`)

### Run
1. Open `android-genus-minimal/` in Android Studio.
2. Sync Gradle.
3. Run `app` on a device.

Note: `local.properties` is intentionally not committed. Your environment must provide the Android SDK path.

The demo:
- plays `40hz_GENUS_optimal.wav` from `app/src/main/assets/`
- renders full-screen sinusoidal luminance modulation
- logs session rows locally and allows exporting a CSV to `Downloads/`

## Data and Privacy

The repository is designed to operate without collecting personal data by default. If you export CSV logs, treat them as potentially sensitive and do not upload them to public issue trackers.

See:
- `docs/open-source-readiness/Data_Deidentification_Standard.md`
- `docs/open-source-readiness/OpenSource_Risk_Assessment.md`

## Third-Party Materials

The public repository should not include third-party copyrighted PDFs. Maintainers should replace any such artefacts with citations and links.

See: [docs/references/Bibliography.md](docs/references/Bibliography.md)

## Open-Source Readiness

This repository includes a structured open-source risk assessment and mitigation plan:
- `docs/open-source-readiness/OpenSource_Risk_Assessment.md`
- `docs/open-source-readiness/ThirdParty_Dependency_Audit.md`
- `SECURITY.md` (security vulnerabilities and safety incident routing)

Medical-adjacent safety and regulatory narratives/templates:
- `docs/medical-safety/Regulatory_and_Safety_Pack.md`

Branding and naming templates (for GitHub publication):
- `docs/branding/Brand_Naming_System.md`
- `docs/branding/Trademark_Terms_Domain_Verification_Template.md`
- `docs/branding/Translation_Certification_Statement_Template.md`

## Standards and Interoperability (Documentation-Level)

Where applicable, documents provide:
- SNOMED CT usage guidance (no redistribution of SNOMED CT content)
- ICD-11 referencing style (contextual taxonomy only)
- HL7 FHIR compatibility statement (scope-limited)
- ISO 14155 traceability table template
- IEEE 2857 transparency report template (model-related; may be not applicable)

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md). Contributions must not include any real patient data or clinical claims.

## Citation

If you use this repository in academic work, please cite it. See [CITATION.cff](CITATION.cff).

## Licence

This project is licensed under the **Mulan Permissive Software License v2**. See [LICENSE](LICENSE).

Commercial terms (optional) are provided in [COMMERCIAL_TERMS.md](COMMERCIAL_TERMS.md).
