package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UnmarkAttendanceCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new UnmarkAttendanceCommand object
 */
public class UnmarkAttendanceCommandParser implements Parser<UnmarkAttendanceCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UnmarkAttendanceCommand
     * and returns a UnmarkAttendanceCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnmarkAttendanceCommand parse(String args) throws ParseException {
        try {
            String[] parts = args.trim().split("\\s+");
            Index[] indexes = new Index[parts.length];
            for (int i = 0; i < parts.length; i++) {
                indexes[i] = ParserUtil.parseIndex(parts[i]);
            }
            return new UnmarkAttendanceCommand(indexes);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnmarkAttendanceCommand.MESSAGE_USAGE), pe);
        }
    }
}
