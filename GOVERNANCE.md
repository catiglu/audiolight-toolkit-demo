# Governance

**Research Use Only. Not for clinical use.**

## Maintainers

The project is maintained by the repository maintainers (“Maintainers”). Maintainers are responsible for:
- triaging issues and pull requests
- reviewing changes with safety and misuse risk in mind
- publishing releases and release notes
- responding to security reports and safety incident reports

## Decision-Making

Maintainers use consensus when possible. If consensus cannot be reached, a maintainer decision stands.

## Release Policy

Before a public release:
- confirm there is no patient data (PHI/PII) in the repository
- confirm safety disclaimers and non-clinical restrictions are present in README and UI-facing text
- confirm third-party copyrighted artefacts are not included
- run dependency audit steps documented in `docs/open-source-readiness/ThirdParty_Dependency_Audit.md`

## Safety-Impacting Changes

Changes that affect stimulus generation, intensity controls, timing, or default settings require:
- an explicit risk note in the PR description
- clear test/verification steps
- maintainer review from at least one person familiar with safety considerations

