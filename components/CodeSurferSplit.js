import CodeSurfer from "code-surfer";
import React, { Fragment } from "react";
import { Box } from 'rebass'
import { Split } from 'mdx-deck/layouts'
import { withDeck, updaters } from "mdx-deck";
import { withTheme } from "styled-components"
import memoizeOne from "memoize-one"

const Title = ({ title }) =>
  typeof title === "string" ? <h1>{title}</h1> : title();

const Notes = ({ notes }) =>
  !notes || typeof notes === "string" ? (
    <p style={{ height: "50px" }}>{notes || "\u00A0"}</p>
  ) : (
    notes()
  )


class InnerCodeSurferSplit extends React.Component {
  constructor(props) {
    super(props);
    const { update, index } = props.deck;
    const parsedSteps = this.parseSteps(props.stepsTop || props.stepsBottom);
    const maxStep = parsedSteps.length - 1;
    update(updaters.setSteps(index, maxStep));
  }

  shouldComponentUpdate(nextProps) {
    return !!nextProps.deck.active;
  }

  parseSteps = memoizeOne((steps, notes) => {
    if (!steps) {
      return [{ notes }];
    }

    if (typeof steps === "string") {
      return steps
        .trim()
        .split("\n")
        .map(stepAndNoteString => {
          const [step, notes] = stepAndNoteString.split("> ");
          return {
            step,
            notes
          };
        });
    }

    return steps.map(({ notes, title, ...step }) => ({ step, notes, title }));
  });

  render() {
    let {
      codeTop,
      codeBottom,
      stepsTop,
      stepsBottom,
      title,
      langTop,
      langBottom,
      showNumbers,
      prismTheme,
      notes,
      height = '60vh',
      scale = 0.85,
      theme,
      ...rest
    } = this.props;
    const step = this.props.deck.step || 0

    // theme
    const mdxDeckTheme = theme
    prismTheme = prismTheme || mdxDeckTheme.codeSurfer;
    showNumbers = showNumbers || (prismTheme && prismTheme.showNumbers);

    // Top steps
    const stepsTopWithNotes = this.parseSteps(stepsTop, notes)
    const currentTop =
      stepsTopWithNotes[step >= stepsTopWithNotes.length ? 0 : step]
    const currentStepTop = currentTop.step;

    // Bottom steps
    const stepsBottomWithNotes = this.parseSteps(stepsBottom, notes);
    const currentBottom =
    stepsBottomWithNotes[step >= stepsBottomWithNotes.length ? 0 : step]
    const currentStepBottom = currentBottom.step
    
    // Notes
    const currentNotes = currentTop.notes
    const anyNotes = stepsTop.some(s => s.notes) || stepsBottom.some(s => s.notes)

    return [
      <Box key={'title'} style={{
        position: 'absolute',
        width: '100%'
      }}>
        <h2>{title}</h2>
      </Box>,
      <Split key={'split-layout'}>
        <Fragment>
          <div
            style={{
              flexGrow: 1,
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
              overflow: "hidden",
              height,
              transform: `scale(${scale})`
            }}
            key="codeTop"
          >
            <CodeSurfer
              {...rest}
              code={codeTop}
              step={currentStepTop}
              lang={langTop}
              showNumbers={showNumbers}
              theme={prismTheme}
              monospace={mdxDeckTheme && mdxDeckTheme.monospace}
            />
          </div>
          <div
            style={{
              flexGrow: 1,
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
              overflow: "hidden",
              height,
              transform: `scale(${scale})`
            }}
            key="codeBottom"
          >
            <CodeSurfer
              code={codeBottom}
              step={currentStepBottom}
              lang={langBottom}
              showNumbers={showNumbers}
              theme={prismTheme}
              monospace={mdxDeckTheme && mdxDeckTheme.monospace}
              {...rest}
            />
          </div>
        </Fragment>
      </Split>,
      <Box key={'notes'} style={{
        position: 'absolute',
        width: '100%',
        bottom: 0
      }}>
        {anyNotes && <Notes notes={currentNotes} />}
        <div style={{ height: "35px" }} />
      </Box>
    ]
  }
}

// Things I need to do to avoid props name collisions
const EnhancedCodeSurferSplit = withDeck(withTheme(InnerCodeSurferSplit))
export default ({ theme, ...rest }) => (
  <EnhancedCodeSurferSplit {...rest} prismTheme={theme} />
);