# Contributing Guide (Medical-Adjacent Repository)

**Research Use Only. Not for clinical use.**

Thank you for considering a contribution. Because this repository is medical-adjacent, contributions must meet additional requirements to reduce risk and prevent misuse.

## Non-Negotiable Rules

1. **No patient data.** Do not include PHI/PII, clinical records, or any data that can be linked to an individual.
2. **No clinical claims.** Do not add text (README, UI, docs) that implies diagnosis, treatment, or efficacy.
3. **Safety-first changes.** Any changes affecting stimulus generation, timing, intensity, or rendering must include a short risk note and test/verification steps.
4. **No copyrighted third-party artefacts.** Do not add paywalled PDFs or proprietary documents to the repository.

## Development Setup

- Android demo: open `android-genus-minimal/` in Android Studio and run the `app` configuration.
- Python scripts: use a local virtual environment and pin dependencies where applicable.

## Pull Request Checklist

- [ ] I confirm this PR contains **no** patient data (PHI/PII) or identifiers.
- [ ] I confirm this PR contains **no** clinical claims or medical advice.
- [ ] I confirm third-party content is either:
  - authored by me, or
  - in the public domain, or
  - provided under a compatible licence with attribution, or
  - referenced by link/DOI only.
- [ ] I documented any changes that affect stimulus generation or safety warnings.
- [ ] I ran relevant builds/tests (Android build, basic script run, etc.).
- [ ] I have read and agree to the CLA in `CLA.md`.

## Licence and Contribution Terms

By contributing, you agree your contributions are provided under the repository licence (see `LICENSE`), and you attest you have the right to submit the content.
